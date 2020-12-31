package sample.multi.artifact.cli;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.defaultimpl.DefaultModule;
import sample.multi.artifact.model.Game;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

	App app = Guice.createInjector(new CliModule(), new DefaultModule())
			.getInstance(App.class);

	@Test
	public void shouldReadCommonCase() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-good.txt");
		Game game = app.readInput(path.toString(), System.out);
		Assert.assertTrue(game.getBoards().containsKey("Jeff"));
		Assert.assertTrue(game.getBoards().containsKey("John"));
	}

	@Test
	public void shouldReadAllZeroesCase() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-zeros.txt");
		Game game = app.readInput(path.toString(), System.out);
		Assert.assertTrue(game.getBoards().containsKey("Jack"));
		Assert.assertEquals(0, game.getBoards().get("Jack").getScores().get(9).getValue().intValue());
	}

	@Test
	public void shouldReadPerfectCase() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-perfect.txt");
		Game game = app.readInput(path.toString(), System.out);
		Assert.assertTrue(game.getBoards().containsKey("Clark"));
		Assert.assertEquals(300, game.getBoards().get("Clark").getScores().get(9).getValue().intValue());
	}

	@Test
	public void shouldTolerateUglyInput() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-ugly.txt");
		Game game = app.readInput(path.toString(), System.out);
		Assert.assertTrue(game.getBoards().containsKey("Jeff"));
		Assert.assertEquals(154, game.getBoards().get("Jeff").getScores().get(9).getValue().intValue());
	}

}
