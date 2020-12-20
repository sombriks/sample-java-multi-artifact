package sample.multi.artifact.core;

import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Score;

import java.io.PrintStream;

public class DefaultGamePrinter implements GamePrinter {

	@Override
	public void printGame(Game game, PrintStream out) {
		out.println(game.getCreatedAt());
		out.print("Frame\t\t");
		int i = 0;
		while (++i < 11) out.print(i + "\t\t");
		out.println();
		game.getBoards().forEach((player, board) -> {
			out.println(player);
			out.print("Pinfalls\t");
			board.getScores().forEach(score -> out.print(formatPinfall(score)));
			out.println();
			out.print("Score\t\t");
			board.getScores().forEach(score -> out.print(score.getValue() + "\t\t"));
			out.println();
		});
	}

	private String formatPinfall(Score score) {
		String format = "";
		if (!score.isFinalFrame()) {
			if (score.isStrike()) format = "\tX";
			else {
				format = score.getTake1() + "\t";
				if (score.isSpare()) format += "/";
				else format += score.getTake2() + "";
			}
		} else
			format = maybeStrike(score) + "\t" + maybeSpare(score) + "\t" + lastTake(score);
		return format + "\t";
	}

	private String maybeStrike(Score score) {
		if (score.isStrike()) return "X";
		else return score.getTake1() + "";
	}

	private String maybeSpare(Score score) {
		if (score.isSpare()) return "/";
		else if (score.getTake2() == 10) return "X";
		else return score.getTake2() + "";
	}

	private String lastTake(Score score) {
		if (score.getTake3() == 10) return "X";
		else return score.getTake3() + "";
	}

}
