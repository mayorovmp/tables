package com.example.tables.service;

import java.sql.Timestamp;

public interface TableService {

    /**
     * Порционное удаление записей.
     * @param tableName название таблицы.
     * @param timestamp граница времени, более раннии записи удаляем.
     * @param limit размер порции удаления.
     */
    void delete(String tableName, Timestamp timestamp, int limit);

    /**
     * Генерация данных.
     * @param tableName название таблицы.
     * @param limit кол-во сгенерированных данных.
     */
    void generate(String tableName, int limit);

}
