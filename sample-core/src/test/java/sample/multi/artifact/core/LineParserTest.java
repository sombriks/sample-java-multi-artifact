package sample.multi.artifact.core;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.defaultimpl.DefaultModule;
import sample.multi.artifact.model.Line;

public class LineParserTest {

	private final LineParser parser = Guice.createInjector(new DefaultModule())
			.getInstance(LineParser.class);

	@Test
	public void shouldParseLine() throws Exception {
		Line line = parser.parse("Jeff 7");
		Assert.assertEquals("Jeff",line.getPlayer());
		Assert.assertEquals(7,line.getPins().intValue());
	}

	@Test
	public void shouldParseFoulRow() throws Exception {
		Line line = parser.parse("Clark F");
		Assert.assertEquals("Clark",line.getPlayer());
		Assert.assertEquals(0,line.getPins().intValue());
	}

	@Test(expected = LineParseException.class)
	public void shouldNotParseNull() throws Exception {
		parser.parse(null);
	}

	@Test(expected = LineParseException.class)
	public void shouldNotParseEmpty() throws Exception {
		parser.parse("");
	}

	@Test(expected = LineParseException.class)
	public void shouldNotParseInvalidFormat() throws Exception {
		parser.parse("Alan X 11");
	}

	@Test(expected = LineParseException.class)
	public void shouldNotParseInvalidScore() throws Exception {
		parser.parse("John 15");
	}

}
