package sample.multi.artifact.api.cli;

import com.google.inject.AbstractModule;

public class ApiCliModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ApiCli.class).to(ApiCliApp.class);
	}
}
