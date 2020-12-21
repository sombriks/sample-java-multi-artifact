# sample api cli

This project differs from `sample-cli` because it consumes a REST service also 
sampled in this solution in another module/project.

It mimetizes as much as possible the workings of bare cli artifact, except it
depends on the rest service instead of access directly the business core.

Since it uses the API, it does not rely on `sample-core` project, just
`sample-model`. All business logic is resolved by the REST service in a clean 
and transparent way.