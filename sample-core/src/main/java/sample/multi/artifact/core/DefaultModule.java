package sample.multi.artifact.core;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Inject;
import javax.inject.Provider;

public class DefaultModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(GameBuilder.class).toProvider(DefaultGameBuilderProvider.class);
	}

	@Provides
	public static LineParser provideLineParser() {
		return new DefaultLineParser();
	}

	@Provides
	public static ScoreBoardBuilder provideScoreBoardBuilder() {
		return new DefaultScoreBoardBuilder();
	}

	@Provides
	public static GamePrinter provideGamePrinter() {
		return new DefaultGamePrinter();
	}
}

class DefaultGameBuilderProvider implements Provider<GameBuilder> {

	private final ScoreBoardBuilder scoreBoardBuilder;

	@Inject
	public DefaultGameBuilderProvider(ScoreBoardBuilder scoreBoardBuilder) {
		this.scoreBoardBuilder = scoreBoardBuilder;
	}

	@Override
	public GameBuilder get() {
		return new DefaultGameBuilder(scoreBoardBuilder);
	}
}