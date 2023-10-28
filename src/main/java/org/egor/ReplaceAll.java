package org.egor;

public class ReplaceAll {
    private ReplaceAll() {}

    public static String replaceAll(String input) {
        final char[] inputChars = input.toCharArray();
        char[] result = new char[inputChars.length];

        int i = 0;
        final int j = input.length();

        int count = 0;

        while (i < j) {
            boolean newLineTest = inputChars[i] == '\n';
            boolean quotesTest = inputChars[i] == '"';
            boolean squareBracketsTest = i < j - 1 && inputChars[i] == '[' && inputChars[i + 1] == ']';

            if (!newLineTest) {
                if (quotesTest) {
                    result[count] = '\'';
                } else if (squareBracketsTest) {
                    result[count] = '{';
                    result[count + 1] = '}';
                } else {
                    result[count] = inputChars[i];
                }
            }

            if (!newLineTest) {
                if (squareBracketsTest) {
                    count += 2;
                } else {
                    count++;
                }
            }

            if (squareBracketsTest) {
                i += 2;
            } else {
                i++;
            }
        }

        return new String(result, 0, count);
    }
}
