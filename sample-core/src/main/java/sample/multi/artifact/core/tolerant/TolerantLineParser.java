package sample.multi.artifact.core.tolerant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.core.LineParseException;
import sample.multi.artifact.core.LineParser;
import sample.multi.artifact.model.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TolerantLineParser implements LineParser {

	private static final Logger LOG = LoggerFactory.getLogger(TolerantLineParser.class);

	@Override
	public Line parse(String input) throws LineParseException {
		Line line = new Line();

		if (input == null || "".equals(input.trim()))
			throw new LineParseException("No input", input);

		String[] parts = Stream.of(input.split(" "))
				.filter(i -> !"".equals(i.trim())).toArray(String[]::new);

		if (parts.length != 2)
			throw new LineParseException("Incorrect line format", input);

		line.setPlayer(parts[0]);

		if (Stream.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10").anyMatch(e -> e.equals(parts[1]))) {
			line.setPins(Integer.parseInt(parts[1]));
		} else if ("F".equals(parts[1])) {
			line.setPins(0);
			line.setFoul(true);
		}
		else throw new LineParseException("Invalid pin score", input);
		return line;
	}

	@Override
	public List<Line> readAll(List<String> rawLines) throws LineParseException {
		if(rawLines==null) throw new LineParseException("No lines input present");
		List<Line> lines = new ArrayList<>();
		rawLines.forEach(line -> {
			try {
				lines.add(parse(line));
			} catch (LineParseException ex) {
				LOG.warn("input problem", ex);
			}
		});
		return lines;
	}
}
