package sample.multi.artifact.core;

import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;
import sample.multi.artifact.model.ScoreBoard;

import java.util.Date;
import java.util.stream.Stream;

public class DefaultGameBuilder implements GameBuilder {

	@Override
	public Game fromLines(Line... lines) {
		Game game = new Game();
		game.setCreatedAt(new Date());
		Stream.of(lines).forEach(line -> {
			ScoreBoard board = game.getBoards().get(line.getPlayer());
			if (board == null) {
				board = new ScoreBoard();
				board.setPlayer(line.getPlayer());
				game.getBoards().put(line.getPlayer(), board);
			}
			board.getLines().add(line);
		});
		return game;
	}
}
