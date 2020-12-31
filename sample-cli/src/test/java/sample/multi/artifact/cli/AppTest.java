package sample.multi.artifact.cli;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.defaultimpl.DefaultModule;
import sample.multi.artifact.core.strict.StrictModule;
import sample.multi.artifact.model.Game;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

	App app = Guice.createInjector(new CliModule(), new StrictModule())
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

	@Test(expected = Exception.class)
	public void shouldNotTolerateUglyInput() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-ugly.txt");
		app.readInput(path.toString(), System.out);
	}

	@Test(expected = Exception.class)
	public void shouldNotTolerateTooFewInputs() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-too-few.txt");
		app.readInput(path.toString(), System.out);
	}

	@Test(expected = Exception.class)
	public void shouldNotTolerateTooMuchInputs() throws Exception {
		Path path = Paths.get("..", "input-examples", "input-too-much.txt");
		app.readInput(path.toString(), System.out);
	}

}
