package sample.multi.artifact.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.core.GameBuilder;
import sample.multi.artifact.core.GamePrinter;
import sample.multi.artifact.core.LineParseException;
import sample.multi.artifact.core.LineParser;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AppCli implements App {

	private final LineParser lineParser;
	private final GameBuilder builder;
	private final GamePrinter printer;

	private static final Logger LOG = LoggerFactory.getLogger(AppCli.class);

	@Inject
	public AppCli(LineParser lineParser, GameBuilder builder, GamePrinter printer) {
		this.lineParser = lineParser;
		this.builder = builder;
		this.printer = printer;
	}

	@Override
	public void readInput(String path) throws IOException {
		List<Line> lines = new ArrayList<>();
		Files.readAllLines(new File(path).toPath()).forEach(line -> {
			try {
				lines.add(lineParser.parse(line));
			} catch (LineParseException ex) {
				LOG.warn("input problem", ex);
			}
		});
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		printer.printGame(game, System.out);
	}
}
