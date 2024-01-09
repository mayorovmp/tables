package com.example.tables.service;

public interface TableService {

    /**
     * Порционное удаление записей, у которых поле времени меньше текущего.
     * @param tableName название таблицы.
     * @param limit размер порции удаления.
     */
    void delete(String tableName, int limit);

    /**
     * Генерация данных.
     * @param tableName название таблицы.
     * @param limit кол-во сгенерированных данных.
     */
    void generate(String tableName, int limit);

}
