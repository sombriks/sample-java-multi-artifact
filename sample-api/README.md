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

