package sample.multi.artifact.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import sample.multi.artifact.api.controller.ApiGameController;
import sample.multi.artifact.api.controller.GameController;
import sample.multi.artifact.api.service.ApiGameService;
import sample.multi.artifact.api.service.ApiMigrateService;
import sample.multi.artifact.api.service.GameService;
import sample.multi.artifact.api.service.MigrateService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApiModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Api.class).to(ApiApp.class);
		bind(GameController.class).to(ApiGameController.class);
		bind(GameService.class).to(ApiGameService.class);
		bind(MigrateService.class).to(ApiMigrateService.class);
	}

	@Provides
	public EntityManagerFactory entityManagerFactoryProvider() {
		return Persistence.createEntityManagerFactory("sample-api-pu");
	}
}
