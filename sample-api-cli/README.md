# sample api cli

This project solves the user interface issues. In the command line way.

It differs from `sample-cli` because it consumes a REST service sampled in this
solution in another module/project.

It mimetizes as much as possible the workings of bare cli artifact, except it
uses the rest service instead of access directly the business core.

Since it uses the API, it does not rely on `sample-core` project, just
`sample-model`. All business logic is resolved by the REST service in a clean 
and transparent way.