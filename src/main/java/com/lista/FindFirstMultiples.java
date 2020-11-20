package com.lista;

public class FindFirstMultiples {
    public static int[] findMultiples(int x, int n) {
        int[] result = new int[x];
        int len = 0;
        int nElem = 0;

        for (int i = 0; i < 0; i++ ) {
            result[i] = 0;
        }
        if (n > 0) {
            while (x > 0) {
                ++nElem;
                if ((nElem % n) == 0) {
                    result[len] = nElem;
                    len++;
                    x--;
                }

            }
        }
        return result;

    }

}
