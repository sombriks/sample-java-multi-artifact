package sample.multi.artifact.model;

public class Score {

	private Long id;
	private Integer frame;
	private Integer take1;
	private Integer take2;
	private Integer take3;
	private Integer value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFrame() {
		return frame;
	}

	public void setFrame(Integer frame) {
		this.frame = frame;
	}

	public Integer getTake1() {
		return take1;
	}

	public void setTake1(Integer take1) {
		this.take1 = take1;
	}

	public Integer getTake2() {
		return take2;
	}

	public void setTake2(Integer take2) {
		this.take2 = take2;
	}

	public Integer getTake3() {
		return take3;
	}

	public void setTake3(Integer take3) {
		this.take3 = take3;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isFinalFrame() {
		return frame == 10;
	}

	public boolean isStrike() {
		return take1 == 10 && !isFinalFrame();
	}

	public void fit() {
		if (take1 == null) take1 = 0;
		if (take2 == null) take2 = 0;
		if (take3 == null) take3 = 0;
	}

	public boolean isFilled() {
		return (isStrike() && !isFinalFrame()) || take1 != null && take2 != null && (!isFinalFrame() || take3 != null);
	}
}
