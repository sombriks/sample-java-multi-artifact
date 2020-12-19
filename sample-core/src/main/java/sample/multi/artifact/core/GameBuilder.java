package sample.multi.artifact.core;

import sample.multi.artifact.model.Game;
import sample.multi.artifact.model.Line;

public interface GameBuilder {
	Game fromLines(Line... lines);
}
