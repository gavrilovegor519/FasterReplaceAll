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
            boolean isNewLine = inputChars[i] == '\n';
            boolean isQuotes = inputChars[i] == '"';
            boolean isSquareBrackets = i < j - 1 && inputChars[i] == '[' && inputChars[i + 1] == ']';

            if (!isNewLine) {
                if (isQuotes) {
                    result[count] = '\'';
                } else if (isSquareBrackets) {
                    result[count] = '{';
                    result[count + 1] = '}';
                } else {
                    result[count] = inputChars[i];
                }
            }

            if (!isNewLine) {
                if (isSquareBrackets) {
                    count += 2;
                } else {
                    count++;
                }
            }

            if (isSquareBrackets) {
                i += 2;
            } else {
                i++;
            }
        }

        return new String(result, 0, count);
    }
}
