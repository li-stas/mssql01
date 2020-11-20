package com.lista;

public class LongestWord {
    public static int findLongest(String sentence) {
        int nLen = 0;
        String cEnd = "";
        String[] aList = sentence.split(" ");
        if (sentence.length() == 0) {
            return nLen;
        }

        for (String cStr : aList ) {
            if (cStr.length() > nLen) {
                nLen = cStr.length();
                cEnd = cStr.substring(cStr.length() - 1);
                if (cEnd.equals(".") || cEnd.equals(",")) {
                    nLen--;
                }
            }
        }
        return  nLen;

    }
}
