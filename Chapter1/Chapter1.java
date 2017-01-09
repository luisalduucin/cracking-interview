import java.util.Arrays;

public class Chapter1 {

  /*
    Excercise 1.1 -> hasUniqueChars
    Excercise 1.2 -> arePermutations
    Excercise 1.3 -> URLify
    Excercise 1.4 -> isPermutationOfPalindrome
<<<<<<< HEAD
    Excercise 1.5 -> oneEditAway
=======
>>>>>>> e79b85e028dbda4b4ea3a189a94486f3760382e4
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

  public static boolean oneEditAway(String word1, String word2) {
    int w1length = word1.length();
    int w2length = word2.length();

    if(word1.equals(word2)) return true;

    if(w1length == w2length) {
      return oneEditReplace(word1, word2);
    } else if(w1length < w2length) {
      return oneEditInsert(word1, word2);
    } else {
      return oneEditInsert(word2, word1);
    }
  }

  private static boolean oneEditReplace(String word1, String word2) {
    int diferences = 0;
    for(int i = 0; i < word1.length(); i++) {
      if(word1.charAt(i) != word2.charAt(i)) {
        diferences++;
      }
      if(diferences > 1){
        return false;
      }
    }
    return true;
  }

  private static boolean oneEditInsert(String word1, String word2) {
    int indexWord1 = 0;
    int indexWord2 = 0;
    int diferences = 0;
    while(indexWord1 < word1.length() && indexWord2 < word2.length()) {
      if(word1.charAt(indexWord1) != word2.charAt(indexWord2)) {
        diferences++;
        indexWord2++;
      } else {
        indexWord1++;
        indexWord2++;
      }
      if(diferences > 1) {
        return false;
      }
    }
    return true;
  }

}
