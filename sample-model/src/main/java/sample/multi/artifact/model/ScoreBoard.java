package sample.multi.artifact.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
	private Long id;
	private String player;
	private List<Score> scores = new ArrayList<>();
	private List<Line> lines = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
}
