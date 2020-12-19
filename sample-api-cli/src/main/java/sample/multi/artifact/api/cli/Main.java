package sample.multi.artifact.api.cli;

public class Main {
  public static void main(String[] args) {
    System.out.println("sample api cli");
    if (args.length > 0)
      System.out.println("reading from [" + args[0] + "]...");
  }
}
