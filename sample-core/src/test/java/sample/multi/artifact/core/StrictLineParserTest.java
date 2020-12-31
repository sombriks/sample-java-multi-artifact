package sample.multi.artifact.core;

import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import sample.multi.artifact.core.strict.StrictModule;
import sample.multi.artifact.model.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrictLineParserTest {

	private final LineParser parser = Guice.createInjector(new StrictModule())
			.getInstance(LineParser.class);

	@Test
	public void shouldParseLines() throws Exception {
		List<String> raw = Stream.of("Jeff 6", "Jeff 4", "Joe F", "Joe 10").collect(Collectors.toList());
		List<Line> lines = parser.readAll(raw);
		Assert.assertEquals(4, lines.size());
	}

	@Test(expected = LineParseException.class)
	public void shouldNOTParseLines() throws Exception {
		List<String> raw = Stream.of("Jeff 6", "Jeff 4", "Joe F", "Joe 10", "Jeff").collect(Collectors.toList());
		parser.readAll(raw);
	}

}
