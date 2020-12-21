# sample api

This module provides a REST API for this solution.

There we try to sample the modern java approach for services/microservices.

There is a growing move to implementations which takes more advantage on JVM 
optimizations by avoiding whenever possible reflection scenarios. That way, java
microservices can be optimized in much more ways, even when transformed into
native images by tools like Graalvm.

Here we chose <https://javalin.io/> as our REST framework. It provides a neat
way to wiring API routes without sacrifice concision even without the
comfortable JAX-RS annotations.

It also provides support for OpenApi annotations and automatic swagger
documentation generation.

We still combine it with Guice for dependency injection purposes, so contracts
remains decoupled from implementations.

We offer two endpoints on this api:

- **/api/new-game**: this one is consumed by `sample-api-cli` project and
  mimetizes the `sample-cli` behavior.
- **/api/games**: this one allows to list saved games so if anyone desires to
  review them it's possible.

There is also a rudimentar migration scheme, just to ensure initial database
state. On a more serious scenario we could adopt Flywaydb.

The entire api/api-client is an extra, so no pressure ;-)
