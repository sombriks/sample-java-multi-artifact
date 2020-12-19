# Sample java multi artifact

Sample to demonstrate mono-repo/multi-projects approach on java solutions

## Dependencies

- java 8
- gradle 6

Built and tested on Fedora 33 with java 8 

## how to run this sample

All you need to do is to build the projects by opening a terminal in the folder
containing this README and use gradle:

```bash
gradle build
gradle :sample-cli:run --args="input-examples/input-good.txt"
``` 

As an alternative, open two consoles. in the first one run:

```bash
gradle build
gradle :sample-api:run
``` 

In the second one:

```bash
gradle build
gradle :sample-api-cli:run --args="input-examples/input-good.txt"
``` 

The APP_ENV environment variable is assumed as `development` so the api-cli will
send the request to <http://localhost:8080/api>.

## why mono-repo/multi-projects

Monolith solutions can be better managed when each functionality is treated as
dedicated project. If migrating some parts of it to microservices, each project
already provides some level of targets to proper feature-strangling.

