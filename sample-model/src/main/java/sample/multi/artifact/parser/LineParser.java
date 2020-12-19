package sample.multi.artifact.parser;

import sample.multi.artifact.model.Line;

public class LineParser {
  public Line parse(String input) throws LineParseException {
    Line line = new Line();

    if (input == null || "".equals(input.trim()))
      throw new LineParseException("No input", input);

    String[] parts = input.split(" ");

    if (parts.length != 2)
      throw new LineParseException("Incorrect line format", input);

    line.setPlayer(parts[0]);
    
    return line;
  }
}
