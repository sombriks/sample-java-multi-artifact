package sample.multi.artifact.model;

import javax.persistence.*;

@Entity
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
