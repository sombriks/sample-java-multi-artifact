package sample.multi.artifact.api;

import io.javalin.Javalin;

public interface Api {
	Javalin createApi();
	void migrateDB() throws Exception ;
}
