package sample.multi.artifact.cli;

public class MainCli {
  public static void main(String... args) {
    System.out.println("sample cli");
    if (args.length > 0)
      System.out.println("reading from [" + args[0] + "]...");
  }
}
