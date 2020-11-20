package com.lista;

public class HasNonLetters {
        public static boolean hasNoneLetters(String blacklist, String phrase) {
            if (blacklist == null || phrase == null) {
                return true;
            }
            if (blacklist.length() == 0 || phrase.length() == 0) {
                return true;
            }
            blacklist = blacklist.toLowerCase();
            char[] aChars =  phrase.toCharArray();
            for (char cChr: aChars) {
                String cStr = String.valueOf(cChr).toLowerCase();
                if (blacklist.contains(cStr)) {
                   return false;
                }
            }
            return true;

        }

}
