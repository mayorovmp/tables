# Работа с таблицами.
При запуске приложения создается две таблицы: `tableA` и `tableB`.
Для хранения используетяс H2.
## Пример запуска в формате Jetbrains HTTP client:
### Для генерации: 
```
POST http://localhost:8080/table
Content-Type: application/json

{
  "tableName": "tableB",
  "limit": 10000
}
```

## Для удаления: 
```
DELETE http://localhost:8080/table
Content-Type: application/json

{
  "tableName": "tableB",
  "limit": 10
}
```
