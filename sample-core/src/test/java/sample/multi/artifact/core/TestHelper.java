package sample.multi.artifact.core;

import sample.multi.artifact.model.Line;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {
	public static List<Line> givenPerfectLines() {
		Line line = new Line("Clark", 10);
		int i = 12;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}

	public static List<Line> givenSomeLines() {
		Line line1 = new Line("Jeff", 6);
		Line line2 = new Line("Ana", 10);
		int i = 20;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line1);
		i = 7;
		while (i-- > 0) lines.add(line2);
		return lines;
	}

	public static List<Line> givenAllZeros() {
		Line line = new Line("Jeff", 0);
		int i = 21;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}

	public static List<Line> givenTooFew() {
		Line line = new Line("Jeff", 0);
		int i = 5;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}

	public static List<Line> givenTooMuch() {
		Line line = new Line("Jeff", 0);
		int i = 50;
		List<Line> lines = new ArrayList<>();
		while (i-- > 0) lines.add(line);
		return lines;
	}
}
