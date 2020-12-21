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

## Java Persistence 

`Line` and `Game` models has well-known JPA annotations but there is no place
for full JPA/Hibernate dependencies. Therefore, only API jar is present,
allowing classes to be properly annotated in order to be consumed by any JPA
runtime present on higher modules (i.e. the sample-api module).
