package sample.multi.artifact.cli;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import sample.multi.artifact.core.*;

public class DefaultCliModule extends AbstractModule {

	@Provides
	public static LineParser provideLineParser() {
		return new DefaultLineParser();
	}

	@Provides
	public static GameBuilder provideGameBuilder() {
		return new DefaultGameBuilder();
	}

	@Provides
	public static GamePrinter provideGamePrinter() {
		return new DefaultGamePrinter();
	}
}
