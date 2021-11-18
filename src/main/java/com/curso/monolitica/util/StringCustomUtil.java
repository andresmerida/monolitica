package com.curso.monolitica.util;

public final class StringCustomUtil {

    private StringCustomUtil() {
        // empty contructor
    }

    public static String toUpperCaseFirstChar(String value) {
        char[] chars = value.toCharArray();

        var index = 0;
        for (char c : chars) {
            if (index == 0) {
                chars[index] = Character.toUpperCase(c);
            } else {
                chars[index] = Character.toLowerCase(c);
            }

            index++;
        }

        return new String(chars);
    }

    public static String toUpperCaseAllFirstChar(String value) {
        String[] values = value.split(" ");
        var resStringBuilder = new StringBuilder();
        var index = 0;
        for (String string : values) {
            if (index == 0) {
                resStringBuilder.append(toUpperCaseFirstChar(string));
            } else {
                resStringBuilder.append(" ").append(toUpperCaseFirstChar(string));
            }

            index++;
        }

        return resStringBuilder.toString();
    }
}
