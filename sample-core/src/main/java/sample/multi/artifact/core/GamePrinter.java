package sample.multi.artifact.core;

import sample.multi.artifact.model.Game;

import java.io.PrintStream;

public interface GamePrinter {
	void printGame(Game game, PrintStream out);
}
