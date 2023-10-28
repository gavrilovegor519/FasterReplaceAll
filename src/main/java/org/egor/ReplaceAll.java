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
            boolean newLine = inputChars[i] == '\n';
            boolean quotes = inputChars[i] == '"';
            boolean squareBrackets = i < j - 1 && inputChars[i] == '[' && inputChars[i + 1] == ']';

            if (!newLine) {
                if (quotes) {
                    result[count] = '\'';
                } else if (squareBrackets) {
                    result[count] = '{';
                    result[count + 1] = '}';
                } else {
                    result[count] = inputChars[i];
                }
            }

            if (!newLine) {
                if (squareBrackets) {
                    count += 2;
                } else {
                    count++;
                }
            }

            if (squareBrackets) {
                i += 2;
            } else {
                i++;
            }
        }

        return new String(result, 0, count);
    }
}
