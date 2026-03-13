# AUTO_FRONT_POM_FACTORY

Framework de automatización E2E para frontend usando **Serenity BDD + Cucumber + Selenium** con patrón **Page Object Model (POM)** y ejecución con **Gradle**.

El flujo actual automatiza la creación de tickets desde la UI en una aplicación disponible en `http://localhost:3000`.

## Stack técnico

- Java 17
- Gradle Wrapper
- Serenity BDD `5.3.2`
- Cucumber (JUnit Platform Engine)
- Selenium WebDriver (Chrome)

## Estructura del proyecto

```text
src/test/java/org/nahulemes/pom
├── base         # Clases base para páginas
├── pages        # Page Objects
├── runners      # Suite de ejecución Cucumber
├── tests        # Step definitions y steps de negocio
└── utils        # Datos de prueba/fábricas

src/test/resources
├── features     # Escenarios Gherkin
└── serenity.conf
```

## Prerrequisitos

- JDK 17 instalado
- Google Chrome instalado
- ChromeDriver compatible con tu versión de Chrome (o configurar `CHROME_BIN`/propiedades por línea de comandos)
- Aplicación bajo prueba corriendo en `http://localhost:3000`

## Ejecución local

### 1) Ejecutar pruebas con configuración por defecto

```bash
./gradlew clean test aggregate
```

### 2) Ejecutar en modo headless (recomendado para local sin UI)

```bash
./gradlew clean test aggregate \
  -Dwebdriver.driver=chrome \
  -Dheadless.mode=true \
  -Dwebdriver.base.url=http://localhost:3000
```

## Reportes

- Reporte Serenity (single-page): `target/site/serenity/index.html`
- Reporte de tests de Gradle: `build/reports/tests/test/index.html`

## Escenario automatizado actual

- `Ticket creation`: login como admin, creación de ticket con campos requeridos y validación en el listado.

Feature:

- `src/test/resources/features/ticket_creation.feature`

Runner:

- `src/test/java/org/nahulemes/pom/runners/CucumberTestSuite.java`

## Nota importante

Actualmente las credenciales de admin están hardcodeadas en:

- `src/test/java/org/nahulemes/pom/tests/TicketCreationSteps.java`

Para robustez y seguridad, se recomienda moverlas a variables de entorno o archivo de configuración.

Proyecto creado por Nahuel Lemes - [GitHub](https://github.com/nahulemesF)
