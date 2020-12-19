# sample model

This module defines relevant model classes to the solution.

Such models are put in a separate project so the model-related classpath don't 
get tainted by other higher level implementations.

## models

- **Line**: Our basic input. each valid row recovered from text file. 
- **Game**: The collection of ScoreBoards for each player discovered in the text
  file. 
- **ScoreBoard**: Collection of Scores for each player. Used to proper organize
  the maximum of 10 scores. 
- **Score**: An individual Score. 

Model project also includes `LineParser`, which knows how to transform a String
into a valid Line. If possible.
