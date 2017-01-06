import java.util.Arrays;

public class Chapter1 {

  /*
    Excercise 1.1 -> hasUniqueChars
    Excercise 1.2 -> arePermutations
  */

  public static boolean hasUniqueChars(String word) {
    char[] asArray = word.toCharArray();
    boolean[] asciiTable = new boolean[256];

    for(int c : asArray) {
      if(asciiTable[c]) {
        return false;
      }
      asciiTable[c] = true;
    }
    return true;
  }

  public static boolean arePermutations(String word1, String word2) {
    char[] word1Array = word1.toCharArray();
    char[] word2Array = word2.toCharArray();

    Arrays.sort(word1Array);
    Arrays.sort(word2Array);

    return Arrays.equals(word1Array, word2Array);
  }

}
