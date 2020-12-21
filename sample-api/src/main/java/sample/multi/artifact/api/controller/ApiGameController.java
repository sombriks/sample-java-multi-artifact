package sample.multi.artifact.api.controller;

import io.javalin.http.Context;
import io.javalin.plugin.json.JavalinJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.api.service.GameService;
import sample.multi.artifact.core.*;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

import javax.inject.Inject;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ApiGameController implements GameController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiGameController.class);

	private final LineParser parser;
	private final GameBuilder builder;
	private final GamePrinter printer;
	private final GameService service;

	@Inject
	public ApiGameController(
			LineParser parser,
			GameBuilder builder,
			GamePrinter printer,
			GameService service
	) {
		this.service = service;
		this.printer = printer;
		this.builder = builder;
		this.parser = parser;
	}

	@Override
	public void newGame(Context context) {

		List<String> inputs = null;
		try {
			inputs = JavalinJson.fromJson(context.body(), List.class);
		} catch (Exception ex) {
			LOG.error("invalid payload", ex);
			context.status(422).result("invalid payload");
		}

		if (inputs == null) return;

		List<Line> lines = new ArrayList<>();

		inputs.forEach(input -> {
			try {
				lines.add(parser.parse(input));
			} catch (LineParseException ex) {
				LOG.warn("input problem", ex);
			}
		});

		try {
			Game game = builder.fromLines(lines.toArray(new Line[0]));
			try (PrintStream out = new PrintStream(context.res.getOutputStream())) {
				context.contentType("text/plain");
				printer.printGame(game, out);
			}
			service.save(game);
		} catch (GameBuilderException ex) {
			LOG.error("game building problem", ex);
			context.status(422).result("game building problem");
		} catch (IOException ex) {
			LOG.error("game printing problem", ex);
			context.status(422).result("game printing problem");
		}
	}

	@Override
	public void list(Context context) {
		context.json(service.list());
	}
}
