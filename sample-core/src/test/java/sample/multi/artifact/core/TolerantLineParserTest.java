package sample.multi.artifact.core;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.defaultimpl.DefaultModule;
import sample.multi.artifact.model.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TolerantLineParserTest {

	private final LineParser parser = Guice.createInjector(new DefaultModule())
			.getInstance(LineParser.class);

	@Test
	public void shouldParseLine() throws Exception {
		Line line = parser.parse("Jeff 7");
		Assert.assertEquals("Jeff", line.getPlayer());
		Assert.assertEquals(7, line.getPins().intValue());
	}

	@Test
	public void shouldParseFoulRow() throws Exception {
		Line line = parser.parse("Clark F");
		Assert.assertEquals("Clark", line.getPlayer());
		Assert.assertEquals(0, line.getPins().intValue());
		Assert.assertTrue(line.isFoul());
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

	@Test
	public void shouldTolerateInvalidInput() throws Exception {
		List<String> raw = Stream.of("Jeff 6", "Jeff 4", "Joe F", "Joe 10", "Jeff").collect(Collectors.toList());
		List<Line> lines = parser.readAll(raw);
		Assert.assertEquals(4, lines.size());
	}

}
