package sample.multi.artifact.api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import sample.multi.artifact.core.DefaultModule;


public class ApiMain {

  public static void main(String[] args) {

    Injector container = Guice.createInjector(new ApiModule(), new DefaultModule());

    Api api = container.getInstance(Api.class);

    api.createApi().start(8080);
  }
}
