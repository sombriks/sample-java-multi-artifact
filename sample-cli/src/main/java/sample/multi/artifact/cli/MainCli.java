package sample.multi.artifact.cli;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.core.GameBuilder;
import sample.multi.artifact.core.GamePrinter;
import sample.multi.artifact.core.LineParseException;
import sample.multi.artifact.core.LineParser;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MainCli {

	private static final Logger LOG = LoggerFactory.getLogger(MainCli.class);

	public static void main(String... args) throws IOException {

		Injector injector = Guice.createInjector(new DefaultCliModule());
		LineParser lineParser = injector.getInstance(LineParser.class);

		if (args.length < 1) {
			System.out.println("Please inform the file input path");
			return;
		}

		List<Line> lines = new ArrayList<>();
		Files.readAllLines(new File(args[0]).toPath()).forEach(line -> {
			try {
				lines.add(lineParser.parse(line));
			} catch (LineParseException ex) {
				LOG.warn("input problem", ex);
			}
		});

		GameBuilder builder = injector.getInstance(GameBuilder.class);
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		GamePrinter printer = injector.getInstance(GamePrinter.class);
		printer.printGame(game,System.out);
	}
}
