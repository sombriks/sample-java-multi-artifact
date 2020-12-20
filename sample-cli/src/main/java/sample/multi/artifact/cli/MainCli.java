package sample.multi.artifact.cli;

import com.google.inject.Guice;
import com.google.inject.Injector;
import sample.multi.artifact.core.DefaultModule;

import java.io.IOException;

public class MainCli {

	public static void main(String... args) throws IOException {

		if (args.length < 1) {
			System.out.println("Please inform the file input path");
			return;
		}
		Injector injector = Guice.createInjector(new CliModule(), new DefaultModule());
		App app = injector.getInstance(App.class);
		app.readInput(args[0]);
	}
}
