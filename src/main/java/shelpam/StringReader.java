public class StringReader {
  private char[] data;
  private int index;

  public StringReader(String str) {
    data = str.toCharArray();
  }

  public char nextChar() {
    return data[index++];
  }
}

