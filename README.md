📌 Система обработки заказов (Order Processing)

Научилься:
1. Поднимать Kafka

2. Работать с Producer / Consumer

3. Понимать event-driven архитектуру

4. Обрабатывать ошибки и ретраи

5. Хранить данные в БД

🧠 Архитектура
Client
  |
  v
Order API (Spring Boot)
  |
  |  (Kafka topic: order.created)
  v
Kafka
  |
  v
Order Processor (Spring Boot Consumer)
  |
  |--> DB (PostgreSQL / MySQL)
  |
  |--> Kafka topic: order.processed
