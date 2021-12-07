package cz.acamar.tasks;

public class Task1 {

    /**
     * Task 1. Length of the last word.
     * <p>
     * Given a string s consisting of some words separated by some number of spaces,
     * return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * Example input: "Hello World"
     * Expected output: 5
     *
     * @param str - a string s consisting of some words separated by some number of spaces.
     * @return - the length of the last word in the string.
     */
    public int lengthOfLastWord(String str) {
        // check if str is not null and we can work with it
        if (str != null) {
            // remove leading and trailing spaces
            str = str.trim();
            // get last word from string
            String lastWord = str.substring(str.lastIndexOf(" ") + 1);
            // return length
            return lastWord.length();
        }
        return 0;
    }
}
