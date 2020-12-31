package sample.multi.artifact.core;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.defaultimpl.DefaultModule;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

import java.util.ArrayList;
import java.util.List;

public class TolerantGameBuilderTest {

	private final GameBuilder builder = Guice.createInjector(new DefaultModule())
			.getInstance(GameBuilder.class);

	@Test
	public void shouldParseOnePlayerGame() throws Exception {
		List<Line> perfect = TestHelper.givenPerfectLines();
		Game game = builder.fromLines(perfect.toArray(new Line[0]));
		Assert.assertEquals(10, game.getBoards().get("Clark").getScores().size());
		Assert.assertEquals(300, game.getBoards().get("Clark").getScores().get(9).getValue().intValue());
	}

	@Test
	public void shouldParseTwoPlayersGame() throws Exception {
		List<Line> lines = TestHelper.givenSomeLines();
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		Assert.assertEquals(2,game.getBoards().size());
	}

	@Test
	public void shouldParseAllZeroesGame() throws Exception {
		List<Line> lines = TestHelper.givenAllZeros();
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		Assert.assertEquals(0, game.getBoards().get("Jeff").getScores().get(9).getValue().intValue());
	}

	@Test(expected = GameBuilderException.class)
	public void shouldNotAcceptNullLines() throws Exception {
		builder.fromLines(null);
	}



}
