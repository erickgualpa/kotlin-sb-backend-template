# 🥬 Kotlin + Spring Boot backend template 🖍️

![CI/CD status](https://github.com/erickgualpa/kotlin-sb-backend-template/actions/workflows/maven.yml/badge.svg)
[![](https://img.shields.io/badge/Spring%20Boot%20Version-3.3.6-blue)](/pom.xml)
[![](https://img.shields.io/badge/Java%20Version-21-blue)](/pom.xml)
[![](https://img.shields.io/badge/Kotlin%20Version-2.0.0-blue)](/pom.xml)

🧪 Run tests
<br>

```shell script
./mvnw clean verify
```

📣 This project has been structured following Hexagonal Architecture principles:
https://alistair.cockburn.us/hexagonal-architecture

[//]: # (Directory tree below was generated using 'tree -d -I target' command)

```
.
└── src
    ├── main
    │   ├── kotlin
    │   │   └── org
    │   │       └── egualpam
    │   │           └── contexts
    │   │               └── template
    │   │                   └── kotlinsb
    │   │                       ├── helloworld
    │   │                       │   ├── adapters
    │   │                       │   │   ├── configuration
    │   │                       │   │   └── in
    │   │                       │   │       └── controllers
    │   │                       │   └── application
    │   │                       │       ├── domain
    │   │                       │       ├── ports
    │   │                       │       │   └── out
    │   │                       │       └── usecases
    │   │                       │           ├── command
    │   │                       │           └── query
    │   │                       └── shared
    │   │                           ├── adapters
    │   │                           │   └── configuration
    │   │                           └── application
    │   │                               ├── domain
    │   │                               │   └── exceptions
    │   │                               └── ports
    │   │                                   └── out
    │   └── resources
    └── test
        ├── kotlin
        │   └── org
        │       └── egualpam
        │           └── contexts
        │               └── template
        │                   └── kotlinsb
        │                       ├── architecture
        │                       ├── e2e
        │                       ├── health
        │                       ├── helloworld
        │                       │   └── application
        │                       │       └── usecases
        │                       │           ├── command
        │                       │           └── query
        │                       ├── journey
        │                       └── shared
        │                           └── adapters
        └── resources
```
