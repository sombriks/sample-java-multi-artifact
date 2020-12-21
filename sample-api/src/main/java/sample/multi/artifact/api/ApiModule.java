package sample.multi.artifact.api;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Api.class).to(ApiApp.class);
	}
}
