package sample.multi.artifact.parser;

import sample.multi.artifact.model.Line;

import java.util.stream.Stream;

public class LineParser {
	public Line parse(String input) throws LineParseException {
		Line line = new Line();

		if (input == null || "".equals(input.trim()))
			throw new LineParseException("No input", input);

		String[] parts = input.split(" ");

		if (parts.length != 2)
			throw new LineParseException("Incorrect line format", input);

		line.setPlayer(parts[0]);

		if (Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "F").anyMatch(e -> e.equals(parts[1]))) {

		}

		return line;
	}
}
