package com.lista;

public class ArrayReverser {
    public static String[] reverse(String[] a) {
         /*
        Input:  {"Don't", "worry", ",", "be", "happy", "!"}
        Output: {"!yppa", "heb,y", "r", "ro", "wt'no", "D"}

        */
        int nLenA = a.length;
        String[] aOut = new String[nLenA];
        String cAllWord = "";
        for (int i = 0; i < nLenA; i++) {
            cAllWord += a[i];
        }

        System.out.println(cAllWord);

        //сиволы вобратной последовательности
        String target = cAllWord;
        StringBuffer cbOut = new StringBuffer();
        String cOut = "";
        char[] cChars = target.toCharArray();
        for (int i = cChars.length - 1; i >= 0; i--) {
            cbOut.append(cChars[i]);
        }
        cOut = cbOut.toString();
        System.out.println(cOut);

        target = cOut;
        cChars = target.toCharArray();

        int i = 0; //счетчик символов  обратной строки
        int k = 0; //счетчик слов
        // перебор слов
        for (k = 0; k < nLenA; k++) {
            // a[k] слово из списка и массив символов
            char[] aChrWord = a[k].toCharArray();
            for (int m = 0; m < aChrWord.length; m++) {
                aChrWord[m] = cChars[i];
                i++;
            }
            // массив символов в строку
            String cNewWord = String.valueOf(aChrWord);
            System.out.println(a[k] + "->" + cNewWord);
            aOut[k] = cNewWord;
        }

        return aOut;

    }
}
