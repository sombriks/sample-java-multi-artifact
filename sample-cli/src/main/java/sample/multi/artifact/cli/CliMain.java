package sample.multi.artifact.cli;

import com.google.inject.Guice;
import com.google.inject.Injector;
import sample.multi.artifact.core.strict.StrictModule;

public class CliMain {

	public static void main(String... args) {

		if (args.length < 1) {
			System.out.println("Please inform the file input path");
			return;
		}

		Injector injector = Guice.createInjector(
				new CliModule(), new StrictModule()
		);

		App app = injector.getInstance(App.class);

		try {
			app.readInput(args[0], System.out);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
