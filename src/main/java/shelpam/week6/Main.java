package shelpam.week6;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

  private static void traverse() {
    int[][] a = {{1,2},{2,3,4},{6},{7,8,9}};

    // Print by `length` property.
    for (int i=0; i!=a.length; ++i) {
      for (int j=0; j!=a[i].length; ++j) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();

    // Print by for-each syntax.
    for (int[] b : a) {
      for (int e : b) {
        System.out.print(e +  " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void shuffle() {
    String[] cards = {"红桃A","红桃2","红桃3","红桃4","红桃5","红桃6","红桃7","红桃8","红桃9",
      "红桃10","红桃J","红桃Q","红桃K", "黑桃A","黑桃2","黑桃3","黑桃4","黑桃5","黑桃6","黑桃7",
      "黑桃8", "黑桃9","黑桃10","黑桃J","黑桃Q","黑桃K", "梅花A","梅花2","梅花3","梅花4","梅花5",
      "梅花6","梅花7", "梅花8","梅花9","梅花10","梅花J","梅花Q","梅花K","方片A","方片2","方片3",
      "方片4","方片5","方片6", "方片7","方片8","方片9","方片10","方片J","方片Q","方片K","大王","小王"};

    System.out.println("Before shuffling: " + Arrays.toString(cards));

    final int times = 10000;

    Random rand = new Random();
    for (int i=0; i!=times; ++i) {
      int x = rand.nextInt(cards.length);
      int y = rand.nextInt(cards.length);

      String tmp = cards[x];
      cards[x] = cards[y];
      cards[y] = tmp;
    }

    System.out.println("After shuffling: " + Arrays.toString(cards) + '\n');
  }

  private static void showMath() { // What a method name!
    MathUtil mathUtil = new MathUtil();
    mathUtil.showMe();
  }

  private static void extractOperandsAndOperators() {
    String[] data = {"1.2 +3.4*(5.6-7.8/9)", "-1.2 +3.4*(5.6-7.8/9)", "1.2.3 + 5"};

    Pattern operandsPattern = Pattern.compile("(^-)?\\d+\\.?\\d*");
    Pattern operatorsPattern = Pattern.compile("[\\+\\-\\*/\\(\\)]");

    String[] names = { "operands", "operators" };
    Pattern[] patterns = { operandsPattern, operatorsPattern };

    for (final var s : data) {
      System.out.println("In '" + s + "',");
      for (int i=0; i!=names.length; ++i) {
        String name = names[i];
        Matcher matcher = patterns[i].matcher(s);

        System.out.println(name);
        while (matcher.find()) {
          System.out.print(matcher.group() + " "); // I don't add the results to
          // an array because I have extract the common structure for extract
          // operands and operators. And splitting them is overwhelmingly tiring.
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    traverse();

    shuffle();

    showMath();

    extractOperandsAndOperators();
    // 1
  }

}
