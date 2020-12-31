# Sample java multi artifact

Sample to demonstrate mono-repo/multi-projects approach on java solutions.

Each project honors the maven standard project layout.

## Dependencies

- java 8 (but works on java 11)
- gradle 6.7 (but gradle wrapper is included)

Built and tested on Fedora 33 with java 8 and 11. 
Tools must be present at the command line.

One good way to manage java command line tools is <https://sdkman.io/>.

## How to run this sample

All you need to do is to build the projects by opening a terminal in the folder
containing this README and use gradle:

```bash
./gradlew build
./gradlew :sample-cli:run --args="../input-examples/input-good.txt"
``` 

As an alternative, open two consoles. in the first one run:

```bash
./gradlew build
./gradlew :sample-api:run
``` 

In the second one:

```bash
./gradlew build
./gradlew :sample-api-cli:run --args="../input-examples/input-good.txt"
``` 

The APP_ENV environment variable is assumed as `development` so the api-cli will
send the request to <http://localhost:8080/api>.

Please note: api implementation uses the `tolerant` component versions. The main
Deliverable, _sample-cli_, uses `strict` versions. Both versions are present to
better represent how dependency injection can help to switch implementations
without large changes or even breaking ones. 

## Test Coverage

The jacoco plugin is included on some projects, so it's possible to measure how
much of the code is covered by tests and which situations either need a test
case or already have it.

In order to build the reports:

```bash
./gradlew build
./gradlew jacocoTestReport
``` 

Reports can be found on 
`<project-name>/build/reports/jacoco/test/html/index.html`.

## Why mono-repo/multi-projects

Monolith solutions can be better managed when each functionality is treated as
dedicated project. If migrating some parts of it to microservices, each project
already provides some level of targets to proper feature-strangling.

## Why Guice

Nothing against Spring or JEE, Guice was chosen as DI container just because
it's simple and fits well the needs of the project with a relatively small 
size footprint. Fewer dependencies, lighter classpath.

