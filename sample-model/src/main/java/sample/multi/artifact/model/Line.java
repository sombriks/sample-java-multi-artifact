package sample.multi.artifact.model;

public class Line {

	private Long id;
	private Long scoreBoardId;
	private String player;
	private Integer pins;

	public Line() {
	}

	public Line(String player, Integer pins) {
		this.player = player;
		this.pins = pins;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getScoreBoardId() {
		return scoreBoardId;
	}

	public void setScoreBoardId(Long scoreBoardId) {
		this.scoreBoardId = scoreBoardId;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Integer getPins() {
		return pins;
	}

	public void setPins(Integer pins) {
		this.pins = pins;
	}
}
