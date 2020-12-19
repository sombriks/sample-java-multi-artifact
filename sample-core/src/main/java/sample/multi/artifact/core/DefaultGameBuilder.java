package sample.multi.artifact.core;

import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;
import sample.multi.artifact.model.ScoreBoard;

import javax.inject.Inject;
import java.util.Date;
import java.util.stream.Stream;

public class DefaultGameBuilder implements GameBuilder {

	private final ScoreBoardBuilder scoreBoardBuilder;

	@Inject
	public DefaultGameBuilder(ScoreBoardBuilder scoreBoardBuilder) {
		this.scoreBoardBuilder = scoreBoardBuilder;
	}

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

		game.getBoards().forEach((player, board) -> scoreBoardBuilder.buildScores(board));

		return game;
	}
}
