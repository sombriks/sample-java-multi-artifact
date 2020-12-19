# sample model

This module defines relevant model classes to the solution.

Such models are put in a separate project so the model-related classpath don't 
get tainted by other higher level implementations.

## models

- Game
- Score
- Line

Model project also includes `LineParser`, which knows how to transform a String
into a valid Line. If possible.
