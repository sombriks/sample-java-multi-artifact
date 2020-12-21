package sample.multi.artifact.api;

import io.javalin.Javalin;
import sample.multi.artifact.api.controller.GameController;

import javax.inject.Inject;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ApiApp implements Api {

	private String environment;

	private final GameController gameController;

	@Inject
	public ApiApp(GameController gameController) {
		environment = System.getenv("APP_ENV");
		if (environment == null) environment = "development";
		this.gameController = gameController;
	}

	@Override
	public Javalin createApi() {
		Javalin app = Javalin.create(config -> {
			if ("development".equals(environment)) {
				config.enableCorsForAllOrigins();
				config.enableDevLogging();
			}
		}).routes(() -> {
			path("/api", () -> {
				get("", ctx -> ctx.result("Online"));
				path("/new-game", () -> {
					post(gameController::newGame);
				});
			});
		});
		return app;
	}
}
