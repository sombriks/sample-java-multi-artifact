package sample.multi.artifact.api.service;

import sample.multi.artifact.model.Game;

import java.util.List;

public interface GameService {
	void save(Game game);
	List<Game> list();
}
