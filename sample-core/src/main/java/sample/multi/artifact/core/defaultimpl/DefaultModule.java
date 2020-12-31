package sample.multi.artifact.core.defaultimpl;

import com.google.inject.AbstractModule;
import sample.multi.artifact.core.GameBuilder;
import sample.multi.artifact.core.GamePrinter;
import sample.multi.artifact.core.LineParser;
import sample.multi.artifact.core.ScoreBoardBuilder;
import sample.multi.artifact.core.tolerant.TolerantScoreBoardBuilder;
import sample.multi.artifact.core.tolerant.TolerantLineParser;

public class DefaultModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LineParser.class).to(TolerantLineParser.class);
		bind(GameBuilder.class).to(DefaultGameBuilder.class);
		bind(ScoreBoardBuilder.class).to(TolerantScoreBoardBuilder.class);
		bind(GamePrinter.class).to(DefaultGamePrinter.class);
	}

}