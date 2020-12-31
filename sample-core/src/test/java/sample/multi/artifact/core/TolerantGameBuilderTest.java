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
	public void shouldParseOnePlayerGame() throws GameBuilderException {
		List<Line> perfect = givenPerfectLines();
		Game game = builder.fromLines(perfect.toArray(new Line[0]));
		Assert.assertEquals(10, game.getBoards().get("Clark").getScores().size());
		Assert.assertEquals(300, game.getBoards().get("Clark").getScores().get(9).getValue().intValue());
	}

	@Test
	public void shouldParseTwoPlayersGame() throws GameBuilderException {
		List<Line> lines = givenSomeLines();
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		Assert.assertEquals(2,game.getBoards().size());
	}

	@Test
	public void shouldParseAllZeroesGame() throws GameBuilderException {
		List<Line> lines = givenAllZeros();
		Game game = builder.fromLines(lines.toArray(new Line[0]));
		Assert.assertEquals(0, game.getBoards().get("Jeff").getScores().get(9).getValue().intValue());
	}

	@Test(expected = GameBuilderException.class)
	public void shouldNotAcceptNullLines() throws GameBuilderException {
		builder.fromLines(null);
	}

	private List<Line> givenPerfectLines() {
		Line line = new Line("Clark", 10);
		int i = 13;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}

	private List<Line> givenSomeLines() {
		Line line1 = new Line("Jeff", 6);
		Line line2 = new Line("Ana", 10);
		int i = 20;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line1);
		i = 7;
		while (i-- > 0) lines.add(line2);
		return lines;
	}

	private List<Line> givenAllZeros() {
		Line line = new Line("Jeff", 0);
		int i = 13;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}

}
