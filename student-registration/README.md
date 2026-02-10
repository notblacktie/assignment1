# Student Registration (Console Java)

This project implements a **student registration** system with a layered architecture:

- `domain` - domain entities
- `repository` - repository interfaces
- `repository.memory` - in-memory repository implementations
- `service` - business logic and CRUD orchestration
- `strategy` - grading strategy pattern
- `factory` - strategy factory
- `exception` - custom exceptions
- `app` - entry point and demo runner

## Implemented requirements

- Java console app, no DBMS/frameworks
- In-memory storage (`Map`, `List`)
- CRUD via service layer
- OOP with encapsulation, inheritance, composition, interfaces
- SOLID-aligned architecture (SRP, OCP, DIP, ISP)
- Patterns:
  - Repository
  - Strategy (plus Factory helper)

## Run

```bash
cd student-registration
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out app.Main
```
