# Jackpot Service 

Spring Boot implementation (mock Kafka) of the Jackpot Bets task.

## Requirements

To build and run this project locally, you must have:

- **Java Runtime Environment (JRE) 21**  
- **Gradle 8.6 or newer**  

## Run locally

Build, run tests and run application:
```
./gradlew build
./gradlew bootRun
```
Open in browser Swagger-UI http://localhost:8080/swagger-ui/index.html

## API Request Body Structure

### POST `/api/bets`
Publishes a bet to Kafka and stores it in the database.

**Request Body (JSON):**

```json
{
  "betId": "1",
  "userId": "1",
  "jackpotId": "1",
  "amount": 150.0
}
```

### GET `/api/rewards/{betId}`
Evaluate reward for a bet using {betId}

A sample jackpot is seeded with id `J1` on startup.
