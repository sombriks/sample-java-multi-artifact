package sample.multi.artifact.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;
import sample.multi.artifact.model.ScoreBoard;

import javax.inject.Inject;
import java.util.Date;
import java.util.stream.Stream;

public class DefaultGameBuilder implements GameBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultGameBuilder.class);

	private final ScoreBoardBuilder scoreBoardBuilder;

	@Inject
	public DefaultGameBuilder(ScoreBoardBuilder scoreBoardBuilder) {
		this.scoreBoardBuilder = scoreBoardBuilder;
	}

	@Override
	public Game fromLines(Line... lines) throws GameBuilderException {
		if(lines == null) throw new GameBuilderException("Line array cannot be null");
		LOG.debug("Reading "+lines.length+" lines");
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