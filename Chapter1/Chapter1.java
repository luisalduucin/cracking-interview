public class Chapter1 {

  /*
    Excercise 1.1 -> hasUniqueChars()
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

}
