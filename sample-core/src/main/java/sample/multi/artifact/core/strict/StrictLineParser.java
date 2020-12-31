package sample.multi.artifact.core.strict;

import sample.multi.artifact.core.LineParseException;
import sample.multi.artifact.core.tolerant.TolerantLineParser;
import sample.multi.artifact.model.Line;

import java.util.ArrayList;
import java.util.List;

public class StrictLineParser extends TolerantLineParser {

	@Override
	public List<Line> readAll(List<String> rawLines) throws LineParseException {
		if (rawLines == null) throw new LineParseException("No lines input present");
		List<Line> lines = new ArrayList<>();
		for (String raw : rawLines)
			lines.add(parse(raw));
		return lines;
	}
}
