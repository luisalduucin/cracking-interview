import java.util.Arrays;

public class Chapter1 {

  /*
    Excercise 1.1 -> hasUniqueChars
    Excercise 1.2 -> arePermutations
    Excercise 1.3 -> URLify
    Excercise 1.4 -> isPermutationOfPalindrome
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

  public static void URLify(char[] string, int trueLength) {
    int lastIndex = string.length - 1;
    for(int i = trueLength - 1; i >= 0; i--) {
      if(string[i] == ' ') {
        string[lastIndex--] = '0';
        string[lastIndex--] = '2';
        string[lastIndex--] = '%';
      } else {
        string[lastIndex--] = string[i];
      }
    }
  }

  public static boolean isPermutationOfPalindrome(String phrase) {
    final int charRange = ('z' - 'a') + 1;
    String lowercasePhrase = phrase.toLowerCase();
    int[] charFrequency = new int[charRange];

    for (int i = 0; i < phrase.length(); i++) {
      char c = lowercasePhrase.charAt(i);
      if(c <= 'z' && c >= 'a') {
        charFrequency['z' - c]++;
      }
    }

    int oddCount = 0;
    for(int i = 0; i < charRange; i++) {
        if(charFrequency[i] % 2 != 0) {
          oddCount++;
        }
    }

    if(oddCount > 1) {
      return false;
    }
    return true;
  }

}
