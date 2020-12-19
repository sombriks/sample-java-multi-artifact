package sample.multi.artifact.parser;

public class LineParseException extends Exception {
  private static final long serialVersionUID = 481460405176740281L;
  private String originalInput;

  public LineParseException(String originalInput) {
    super(originalInput);
    this.originalInput = originalInput;
  }

  public LineParseException(String message, String originalInput) {
    super(message + " [" + originalInput + "]");
    this.originalInput = originalInput;
  }

  public String getOriginalInput() {
    return originalInput;
  }
}