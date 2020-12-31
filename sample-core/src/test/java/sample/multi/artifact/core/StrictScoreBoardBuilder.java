package sample.multi.artifact.core;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.strict.StrictModule;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

import java.util.List;

public class StrictScoreBoardBuilder {

	private final GameBuilder builder = Guice.createInjector(new StrictModule())
			.getInstance(GameBuilder.class);

	@Test
	public void shouldParsePerfectGame() throws Exception {
		List<Line> perfect = TestHelper.givenPerfectLines();
		Game game = builder.fromLines(perfect.toArray(new Line[0]));
		Assert.assertEquals(10, game.getBoards().get("Clark").getScores().size());
		Assert.assertEquals(300, game.getBoards().get("Clark").getScores().get(9).getValue().intValue());
	}

	@Test
	public void shouldParseAllZeroesGame() throws Exception {
		List<Line> zeros = TestHelper.givenAllZeros();
		Game game = builder.fromLines(zeros.toArray(new Line[0]));
		Assert.assertEquals(10, game.getBoards().get("Jeff").getScores().size());
		Assert.assertEquals(0, game.getBoards().get("Jeff").getScores().get(9).getValue().intValue());
	}

	@Test(expected = ScoreBoardException.class)
	public void shouldFailTooFewScores() throws Exception {
		List<Line> few = TestHelper.givenTooFew();
		builder.fromLines(few.toArray(new Line[0]));
	}

	@Test(expected = ScoreBoardException.class)
	public void shouldFailTooMuchScores() throws Exception {
		List<Line> much = TestHelper.givenTooMuch();
		builder.fromLines(much.toArray(new Line[0]));
	}
}
