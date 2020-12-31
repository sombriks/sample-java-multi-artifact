package sample.multi.artifact.core.tolerant;

import sample.multi.artifact.core.ScoreBoardBuilder;
import sample.multi.artifact.model.Line;
import sample.multi.artifact.model.Score;
import sample.multi.artifact.model.ScoreBoard;

public class TolerantScoreBoardBuilder implements ScoreBoardBuilder {
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

			if (score.getTake1() == null) {
				score.setTake1(line.getPins());
				score.setFoul1(line.isFoul());
			} else if (score.getTake2() == null) {
				score.setTake2(line.getPins());
				score.setFoul2(line.isFoul());
			}	else if (score.getTake3() == null && score.isFinalFrame()) {
				score.setTake3(line.getPins());
				score.setFoul3(line.isFoul());
			}

			if(score.isFilled() && score.isFinalFrame()) break;

			if (score.isFilled()) {
				score.fit();
				score = null;
			}
		}

		scoreBoard.getScores().forEach(Score::fit);

		while (scoreBoard.getScores().size() < 10) {
			score = new Score();
			scoreBoard.getScores().add(score);
			score.setFrame(scoreBoard.getScores().size());
			score.fit();
		}

		for (int i = 0; i < 10; i++) {
			score = scoreBoard.getScores().get(i);
			int value = score.getTake1() + score.getTake2();
			if (score.isSpare() && i < 9) {
				Score next1 = scoreBoard.getScores().get(i + 1);
				value += next1.getTake1();
			}
			if (score.isFinalFrame())
				value += score.getTake3();
			if (score.isStrike() && i < 9) {
				Score next1 = scoreBoard.getScores().get(i + 1);
				value += next1.getTake1();
				if (next1.isStrike() && i < 8) {
					Score next2 = scoreBoard.getScores().get(i + 2);
					value += next2.getTake1();
				} else value += next1.getTake2();
			}
			if (i > 0) {
				Score prev = scoreBoard.getScores().get(i - 1);
				value += prev.getValue();
			}
			score.setValue(value);
		}
	}
}
