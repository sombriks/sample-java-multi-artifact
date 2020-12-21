package sample.multi.artifact.api;

import io.javalin.Javalin;
import sample.multi.artifact.api.controller.GameController;
import sample.multi.artifact.api.service.MigrateService;

import javax.inject.Inject;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ApiApp implements Api {

	private String environment;

	private final GameController gameController;
	private final MigrateService migrate;

	@Inject
	public ApiApp(GameController gameController, MigrateService migrate) {
		environment = System.getenv("APP_ENV");
		if (environment == null) environment = "development";
		this.gameController = gameController;
		this.migrate = migrate;
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
				get("/games", gameController::list);
				path("/new-game", () -> {
					post(gameController::newGame);
				});
			});
		});
		return app;
	}

	@Override
	public void migrateDB()  throws Exception {
		migrate.latest();
	}
}
