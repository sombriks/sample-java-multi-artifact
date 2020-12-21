package sample.multi.artifact.api.cli;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

public class ApiCliMain {

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Please provide input path");
			return;
		}
		Injector container = Guice.createInjector(new ApiCliModule());
		ApiCli client = container.getInstance(ApiCli.class);
		client.readInput(args[0]);
	}
}
