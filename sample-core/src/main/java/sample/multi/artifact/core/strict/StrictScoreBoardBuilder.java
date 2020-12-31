package sample.multi.artifact.core.strict;

import sample.multi.artifact.core.ScoreBoardException;
import sample.multi.artifact.core.tolerant.TolerantScoreBoardBuilder;
import sample.multi.artifact.model.ScoreBoard;

public class StrictScoreBoardBuilder extends TolerantScoreBoardBuilder {

	@Override
	protected void checkScores(ScoreBoard scoreBoard) throws ScoreBoardException {
		if (scoreBoard.getScores().size() < 10) throw new ScoreBoardException("Too few scores");
		if (scoreBoard.getScores().size() > 10) throw new ScoreBoardException("Too much scores");
	}
}
