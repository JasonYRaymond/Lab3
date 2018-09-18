import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
  /**
   * Retrieve contents from a URL and return them as a string.
   *
   * @param url url to retrieve contents from
   * @return the contents from the url as a string, or an empty string on error
   */
  public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
      urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
      return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
  }

  public static String wordCounting(final String str) {
    return "The total word count is " + urlToString(str).length();
  }

  public static String countingOneWord(final String str, final String key, final boolean caseSensitivity) {
    int wordCount = 0;
    String[] operation = urlToString(str).split(" ");
    if (caseSensitivity) {
      for (int i = 0; i < operation.length; i += 1) {
        if (operation[i].indexOf(key) != -1) {
          wordCount += 1;
        }
      }
    } else {
      for (int i = 0; i < operation.length; i += 1) {
        if (operation[i].toLowerCase().indexOf(key.toLowerCase()) != -1) {
          wordCount += 1;
        }
      }
    }
    return "The word " + key + " appeared " + wordCount + " times.";
  }

  public static void main(String[] args) {
    //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    System.out.println(wordCounting("http://erdani.com/tdpl/hamlet.txt"));
    System.out.println(countingOneWord("http://erdani.com/tdpl/hamlet.txt", "prince", true));
    System.out.println(countingOneWord("http://erdani.com/tdpl/hamlet.txt", "prince", false));
  }
}