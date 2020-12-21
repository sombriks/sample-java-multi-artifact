package sample.multi.artifact.api;

import com.google.inject.AbstractModule;
import sample.multi.artifact.api.controller.ApiGameController;
import sample.multi.artifact.api.controller.GameController;

public class ApiModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Api.class).to(ApiApp.class);
		bind(GameController.class).to(ApiGameController.class);
	}
}
