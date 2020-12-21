package sample.multi.artifact.api.cli;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {
	@POST("api/new-game")
	Call<ResponseBody> newGame(@Body List<String> inputs);
}
