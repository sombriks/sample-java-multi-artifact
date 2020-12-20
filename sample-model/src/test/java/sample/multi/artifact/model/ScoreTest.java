package sample.multi.artifact.model;

import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

	@Test
	public void shouldBeAStrike() {
		Score score = new Score();
		score.setTake1(10);
		Assert.assertTrue(score.isStrike());
	}

	@Test
	public void shouldBeASpare() {
		Score score = new Score();
		score.setTake1(7);
		score.setTake2(3);
		Assert.assertTrue(score.isSpare());
	}

	@Test
	public void shouldBeTheFinalFrame() {
		Score score = new Score();
		score.setFrame(10);
		Assert.assertTrue(score.isFinalFrame());
	}

	@Test
	public void shouldBeFilled() {
		Score score = new Score();
		score.fit();
		Assert.assertEquals(0, score.getTake1().intValue());
		Assert.assertEquals(0, score.getTake2().intValue());
		Assert.assertEquals(0, score.getTake3().intValue());
	}
}
