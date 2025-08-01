# Automation API - Notificaciones de Compra

## Tecnologías
- Java 11
- Maven
- Rest Assured
- Cucumber + Gherkin
- JUnit
- Faker
- OpenAI API
- Sybase Central
- ExtentReports

## Estructura
- `src/main/java/utils`: Clases utilitarias (DB, Faker, IA)
- `src/test/java/stepdefinitions`: Paso a paso Gherkin
- `src/test/java/runners`: Ejecución con JUnit
- `src/test/resources/features`: Casos Gherkin
- `src/test/resources/schemas`: JSON Schema

## Ejecución
```bash
mvn test
```

Ver reportes en `target/cucumber-reports/index.html`
