package sample.multi.artifact.core.strict;

import com.google.inject.AbstractModule;
import sample.multi.artifact.core.GameBuilder;
import sample.multi.artifact.core.GamePrinter;
import sample.multi.artifact.core.LineParser;
import sample.multi.artifact.core.ScoreBoardBuilder;
import sample.multi.artifact.core.defaultimpl.DefaultGameBuilder;
import sample.multi.artifact.core.defaultimpl.DefaultGamePrinter;
import sample.multi.artifact.core.tolerant.TolerantLineParser;
import sample.multi.artifact.core.tolerant.TolerantScoreBoardBuilder;

public class StrictModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LineParser.class).to(StrictLineParser.class);
		bind(GameBuilder.class).to(DefaultGameBuilder.class);
		bind(ScoreBoardBuilder.class).to(TolerantScoreBoardBuilder.class);
		bind(GamePrinter.class).to(DefaultGamePrinter.class);
	}
}
