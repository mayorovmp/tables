# Приложение для работы с таблицами.
При запуске приложения создается две таблицы: `tableA` и `tableB`.\
Для хранения используетяс H2. Удаление производится в цикле пакетами.
## Пример запуска в формате Jetbrains HTTP client:
### Генерация тестовых данных:
`tableName` - название таблицы(`tableA` или `tableB`).\
`limit` - кол-во записей.
```
POST http://localhost:8080/table
Content-Type: application/json

{
  "tableName": "tableB",
  "limit": 10000
}
```

## Удаление: 
`tableName` - название таблицы(`tableA` или `tableB`).\
`timestamp` - граница времени, более раннии записи удаляем.\
`limit` - размер пакета для удаления в рамках одного запроса.
```
DELETE http://localhost:8080/table
Content-Type: application/json

{
  "tableName": "tableB",
  "timestamp": "2015-07-05T22:16:18+05",
  "limit": 10
}
```
