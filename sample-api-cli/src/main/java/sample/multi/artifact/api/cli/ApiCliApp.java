package sample.multi.artifact.api.cli;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ApiCliApp implements ApiCli {

	private final Retrofit retrofit;

	public ApiCliApp() {
		String environment = System.getenv("APP_ENV");
		if (environment == null) environment = "development";
		String baseUrl = null;
		if ("development".equals(environment)) baseUrl = "http://localhost:8080";
		// else baseUrl = "https://my.production.service"
		retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
	}

	@Override
	public void readInput(String path) throws IOException {
		List<String> inputs = Files.readAllLines(new File(path).toPath());
		ApiService service = retrofit.create(ApiService.class);
		System.out.println(service.newGame(inputs).execute().body().string());
	}
}
