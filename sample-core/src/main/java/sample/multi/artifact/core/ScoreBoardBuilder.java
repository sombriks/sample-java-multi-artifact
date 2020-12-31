package sample.multi.artifact.core;

import sample.multi.artifact.model.ScoreBoard;

public interface ScoreBoardBuilder {
	void buildScores(ScoreBoard scoreBoard) throws ScoreBoardException;
}
