# Sample java multi artifact

Sample to demonstrate mono-repo/multi-projects approach on java solutions.

Each project honors the maven standard project layout.

## Dependencies

- java 8
- gradle 6.7

Built and tested on Fedora 33 with java 8. Both tools must be present at the 
command line.

One good way to manage java tools is <https://sdkman.io/>.

## How to run this sample

All you need to do is to build the projects by opening a terminal in the folder
containing this README and use gradle:

```bash
gradle build
gradle :sample-cli:run --args="../input-examples/input-good.txt"
``` 

As an alternative, open two consoles. in the first one run:

```bash
gradle build
gradle :sample-api:run
``` 

In the second one:

```bash
gradle build
gradle :sample-api-cli:run --args="../input-examples/input-good.txt"
``` 

The APP_ENV environment variable is assumed as `development` so the api-cli will
send the request to <http://localhost:8080/api>.

## Test Coverage

The jacoco plugin is included on some projects, so it's possible to measure how
much of the code is covered by tests and which situations either need a test
case or already have it.

In order to build the reports:

```bash
gradle build
gradle jacocoTestReport
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

