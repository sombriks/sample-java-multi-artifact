package sample.multi.artifact.cli;

import sample.multi.artifact.model.Game;

import java.io.PrintStream;

public interface App {
	Game readInput(String path, PrintStream out) throws Exception;
}
