package sample.multi.artifact.core;

import sample.multi.artifact.model.Line;

public interface LineParser {
	Line parse(String input) throws LineParseException;
}
