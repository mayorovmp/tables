package com.example.tables.controller;

import com.example.tables.dto.Request;
import com.example.tables.service.TableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @DeleteMapping("/table")
    public void deleteTableB(@RequestBody Request request) {
        log.info("Начало удаление данных из таблицы {}", request.getTableName());
        tableService.delete(request.getTableName(), request.getLimit());
        log.info("Конец удаления данных из таблицы {}", request.getTableName());
    }

    @PostMapping("/table")
    public void generateTable(@RequestBody Request request) {
        log.info("Начало генерации данных в таблицу {}", request.getTableName());
        tableService.generate(request.getTableName(), request.getLimit());
        log.info("Конец генерации данных в таблицу {}", request.getTableName());
    }

}
