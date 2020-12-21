package sample.multi.artifact.api;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ApiApp implements Api {

	private String environment;

	public ApiApp() {
		environment = System.getenv("APP_ENV");
		if (environment == null) environment = "development";
	}

	@Override
	public Javalin createApi() {
		Javalin app = Javalin.create(config -> {
			if ("development".equals(environment)){
				config.enableCorsForAllOrigins();
				config.enableDevLogging();
			}
		}).routes(() -> {
			path("/api", () -> {
				get("", ctx -> ctx.result("Online"));
				path("/new-game", () -> {
					post(context -> {

					});
				});
			});
		});
		return app;
	}
}
