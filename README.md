📌 Задача: Система обработки заказов (Order Processing)
🎯 Цель

Научиться:

поднимать Kafka

работать с Producer / Consumer

понимать event-driven архитектуру

обрабатывать ошибки и ретраи

хранить данные в БД

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
