package sample.multi.artifact.core;

import sample.multi.artifact.model.Line;

import java.util.List;

public interface LineParser {
	Line parse(String input) throws LineParseException;
	List<Line> readAll(List<String> readAllLines) throws LineParseException;
}
