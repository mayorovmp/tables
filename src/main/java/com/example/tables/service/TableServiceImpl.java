package com.example.tables.service;

import com.example.tables.entity.TableA;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final static int BATCH_SIZE = 1000;

    private final JdbcTemplate jdbcTemplate;

    /**
     * Цикличное удаление записей порциями, пока итерация возвращает не нулевое кол-во строк.
     * @param tableName название таблицы.
     * @param limit размер порции удаления.
     */
    public void delete(String tableName, int limit) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        var deleted = 0;
        var totalDeleted = 0;
        do {
            // sql-код совместим с H2.
            // Для работы с Postgres, Oracle и др. могут потребоваться правки.
            deleted = jdbcTemplate.update(
                    "delete from " + tableName + " where created_at < ? limit ?",
                    now,
                    limit
            );
            totalDeleted += deleted;
            log.info("Удалили {} записей из таблицы {}", totalDeleted, tableName);
        } while (deleted != 0);
        log.info("Удаление заверщено. Всего из таблицы {} удалено: {}", tableName, totalDeleted);
    }

    /**
     * Пакетная генерация данных, размер пакета зафиксирован в константу.
     * @param tableName название таблицы.
     * @param limit кол-во сгенерированных данных.
     */
    public void generate(String tableName, int limit) {
        var rowA = new ArrayList<TableA>();
        for (var i = 0; i < limit; i++) {
            rowA.add(new TableA(UUID.randomUUID(), new Timestamp(System.currentTimeMillis())));
        }
        jdbcTemplate.batchUpdate(
                "insert into " + tableName + " (id, created_at)  values (?, ?)",
                rowA, BATCH_SIZE, (ps, row) -> {
                    ps.setString(1, row.getId().toString());
                    ps.setTimestamp(2, row.getCreatedAt());
                });
    }
}
