### Hexlet tests and linter status:
[![Actions Status](https://github.com/Someloseyouth/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Someloseyouth/java-project-78/actions)

### Github Actions ans SonarQube status:
[![Java CI](https://github.com/Someloseyouth/java-project-78/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/Someloseyouth/java-project-78/actions/workflows/ci.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Someloseyouth_java-project-78&metric=coverage)](https://sonarcloud.io/dashboard?id=Someloseyouth_java-project-78)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Someloseyouth_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Someloseyouth_java-project-78)

# Валидатор данных (Validator)

**Validator** — это библиотека на Java для декларативной валидации данных.  
Поддерживает строки, числа и отображения (`Map`) с возможностью описывать схему объекта через fluent‑API.

## Возможности

### StringSchema
- `required()` — значение не может быть `null` или пустой строкой.
- `minLength(n)` — минимальная длина строки.
- `contains(substr)` — строка должна содержать указанную подстроку.

### NumberSchema
- `required()` — значение обязательно.
- `positive()` — только положительные числа.
- `range(min, max)` — число в заданном диапазоне.

### MapSchema
- `required()` — `Map` обязательна.
- `sizeof(n)` — ровно `n` пар ключ‑значение.
- `shape(mapOfSchemas)` — валидация значений по схеме для каждого ключа.

## Демонстрация (asciinema)

Проверка `StringSchema`

[![asciicast](https://asciinema.org/a/9GEizaFOWlDkAMgvw6if2c6xM.svg)](https://asciinema.org/a/9GEizaFOWlDkAMgvw6if2c6xM)

Проверка `NumberSchema`

[![asciicast](https://asciinema.org/a/pY4RCUYmjj23A66x3cbimByBL.svg)](https://asciinema.org/a/pY4RCUYmjj23A66x3cbimByBL)

Проверка `MapSchema` (`required`, `sizeof`)

[![asciicast](https://asciinema.org/a/Aa0HNdW7ei8Tt2l5xwsI22uBI.svg)](https://asciinema.org/a/Aa0HNdW7ei8Tt2l5xwsI22uBI)

Проверка `shape` для `MapSchema`

[![asciicast](https://asciinema.org/a/ozkkHkoYZJgQLQjXs7oHM4Frc.svg)](https://asciinema.org/a/ozkkHkoYZJgQLQjXs7oHM4Frc)

## Установка

Убедитесь, что у вас установлены Java 21 и Gradle (или используйте gradle‑wrapper из репозитория).

Клонируйте репозиторий:

```bash
git clone https://github.com/Someloseyouth/java-project-78.git
cd java-project-78/app
```

Соберите проект и запустите тесты:

```bash
./gradlew test
```

