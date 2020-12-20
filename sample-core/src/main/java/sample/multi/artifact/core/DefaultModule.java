package sample.multi.artifact.core;

import com.google.inject.AbstractModule;

public class DefaultModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LineParser.class).to(DefaultLineParser.class);
		bind(LineParser.class).to(DefaultLineParser.class);
		bind(GameBuilder.class).to(DefaultGameBuilder.class);
		bind(ScoreBoardBuilder.class).to(DefaultScoreBoardBuilder.class);
		bind(GamePrinter.class).to(DefaultGamePrinter.class);
	}

}