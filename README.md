# Design Patterns Tasks

This project contains separate Java practice modules about **design patterns**.

Each module is an independent Maven module with its own `README.md` guide. Tests check the student's work.

The modules will grow from simple to harder topics:

```text
creational patterns   (singleton, factory, builder, immutable)
structural patterns   (bridge, filter, decorator, facade, proxy)
behavioral patterns   (strategy, observer, command ...)
```

## Project Structure

```text
design_patterns_tasks/
├── README.md
├── pom.xml
├── .gitignore
├── creational-patterns/
│   ├── README.md
│   ├── pom.xml
│   └── src/
└── structural-patterns/
    ├── README.md
    ├── pom.xml
    └── src/
```

## Current Modules

```text
creational-patterns   - Singleton, Factory, Builder, Immutable
structural-patterns   - Bridge, Filter, Decorator, Facade, Proxy
```

## What You Need

- JDK 21 or newer
- Maven (or the Maven in IntelliJ IDEA)

No database and no framework are needed.

## Run A Module

In IntelliJ: open the `design_patterns_tasks` folder as a Maven project, then run the `Main` class of the module.

In the terminal:

```bash
cd creational-patterns        # or structural-patterns
mvn -q compile
java -cp target/classes com.example.patterns.Main        # creational-patterns
java -cp target/classes com.example.structural.Main      # structural-patterns
```

## Run The Tests

```bash
mvn test
```

Run the tests of one module only:

```bash
mvn test -pl structural-patterns
```

Run one test class only:

```bash
mvn test -Dtest=SingletonTest
```

## Notes

- Each module has a step-by-step guide in its own `README.md`.
- The modules are separate and do not share code.
