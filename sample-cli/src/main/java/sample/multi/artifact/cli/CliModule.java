package sample.multi.artifact.cli;

import com.google.inject.AbstractModule;

public class CliModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(App.class).to(AppCli.class);
	}
}