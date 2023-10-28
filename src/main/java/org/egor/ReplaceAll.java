package org.egor;

public class ReplaceAll {
    private ReplaceAll() {}

    public static String replaceAll(String input) {
        final char[] chars = input.toCharArray();
        char[] result = new char[chars.length];

        int i = 0;
        final int j = input.length();

        int count = 0;

        while (i < j) {
            boolean test1 = chars[i] == '\n';
            boolean test2 = chars[i] == '"';
            boolean test3 = i < j - 1 && chars[i] == '[' && chars[i + 1] == ']';

            if (!test1) {
                if (test2) {
                    result[count] = '\'';
                } else if (test3) {
                    result[count] = '{';
                    result[count + 1] = '}';
                } else {
                    result[count] = chars[i];
                }
            }

            if (!test1) {
                if (test3) {
                    count += 2;
                } else {
                    count++;
                }
            }

            if (test3) {
                i += 2;
            } else {
                i++;
            }
        }

        return new String(result, 0, count);
    }
}
