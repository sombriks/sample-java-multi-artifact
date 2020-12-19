package sample.multi.artifact.core;

import sample.multi.artifact.model.Line;
import sample.multi.artifact.model.Score;
import sample.multi.artifact.model.ScoreBoard;

public class DefaultScoreBoardBuilder implements ScoreBoardBuilder {
	@Override
	public void buildScores(ScoreBoard scoreBoard) {

		scoreBoard.getScores().clear();

		Score score = null;
		for (Line line : scoreBoard.getLines()) {
			if (score == null) {
				score = new Score();
				scoreBoard.getScores().add(score);
				score.setFrame(scoreBoard.getScores().size());
			}

			if (score.getTake1() == null) score.setTake1(line.getPins());
			else if (score.getTake2() == null) score.setTake2(line.getPins());
			else if (score.getTake3() == null && score.isFinalFrame()) score.setTake3(line.getPins());

			if(score.isFilled() || score.isStrike()) {
				score.fit();
				score = null;
			}

		}

		while (scoreBoard.getScores().size() < 10) {
			score = new Score();
			scoreBoard.getScores().add(score);
			score.setFrame(scoreBoard.getScores().size());
			score.fit();
		}


	}
}
