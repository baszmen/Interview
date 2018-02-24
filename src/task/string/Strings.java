package task.string;

public class Strings {
    public boolean uniqeCharacters(String s) {
        int charactersCount = 128;
        boolean[] char_set = new boolean[charactersCount];

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) + " = " + (int)s.charAt(i));
            if (char_set[(int)s.charAt(i)])
                return false;
            char_set[(int)s.charAt(i)] = true;
        }

        return true;
    }

    public boolean isPerumtation(String s1, String s2) {
        int charactersCount = 128;
        int[] char_set = new int[charactersCount];


        for (int i = 0; i < s1.length(); i++)
            char_set[(int)s1.charAt(i)]++;

        for (int i = 0; i < s2.length(); i++)
            char_set[(int)s2.charAt(i)]--;

        for (int i = 0; i < charactersCount; i++)
            if (char_set[i] > 0) return false;
        return true;
    }

    public char[] replaceSpace(char[] charSet, char[] toReplace) {
        return charSet;
    }
}
