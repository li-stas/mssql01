package com.lista;


import org.junit.Assert;

import java.sql.*;
import java.util.Arrays;


/**
 * Hello world!
 *
 */
public class AppPayments
{
    public static void main( String[] args )
    {
       /* Student[] studentsInfo = new  Student[] {
                new Student("Alina", "Ivanova", 30, true),
                new Student("Ivan", "Petrov", 26, false),
                new Student("Irina", "Stetsenko", 35, true),
                new Student("Yurii", "Shvets", 40, true),
                new Student("Daria", "Kovalchyk", 33, false),
                new Student("Olha", "Kulyk", 22, true)

                public int[] getDivisibleNumbers(int[] numbers, int divider) {

        };*/

        /*int[] numbers = {2, 5, 8, 0, 7, 1, -4};
        int divider = 2;*/
        /*int[] numbers = {3, 1, -5, 21, 39, -1, -250, 11, 7, 49};
        int divider = 5;


        System.out.println(Arrays.toString(getDivisibleNumbers(numbers, divider)));*/
       //char[] aRez = removeLetter01("Remove Letters");

        //System.out.println(Arrays.toString(aRez));
        /*System.out.println(Arrays.toString( FindFirstMultiples.findMultiples(3, 4)));
        Assert.assertArrayEquals("Result should be [4, 8, 12] for input x = 3, n = 4\n",
                new int[]{4, 8, 12}, FindFirstMultiples.findMultiples(3, 4));
        System.out.println(Arrays.toString( FindFirstMultiples.findMultiples(2, 0)));*/
       /* System.out.println(LongestWord.findLongest("If life were predictable it would cease to be life, and be without flavor."));
        System.out.println(LongestWord.findLongest("predictable"));*/

       /*System.out.println(HasNonLetters.hasNoneLetters("abcdef", "fgh"));
        System.out.println(HasNonLetters.hasNoneLetters("abcdef", "gh"));*/

        /*Input:  {"Don't", "worry", ",", "be", "happy", "!"}
        Output: {"!yppa", "heb,y", "r", "ro", "wt'no", "D"}*/

        System.out.println(ArrayReverser.reverse(new String[]{"Don't", "worry", ",", "be", "happy", "!"}));

        System.exit(0);

         //String server = "85.223.140.88\\SalesWeb:8084";
        String server = "salesdb.obolon.com\\SalesWeb:8084";
        String user ="1C_DB";
        String password="TC73dfa0a8!";

        String parDate = "17-11-2020";       // $paramDate = date('2018-11-21');
        String passwdTC = "TC164500d0!";

        //Connect to  MSSQL
        String connectionUrl = "jdbc:sqlserver://"
                + "salesdb.obolon.com\\SalesWeb:8084"
                + ";user=1C_DB"
                + ";password=TC73dfa0a8!";

        try (Connection con = DriverManager.getConnection(connectionUrl);
             CallableStatement cstmt = con.prepareCall("{call SalesWeb.dbo.Payments(?,?)}"); ) {
            cstmt.setString(1, parDate);
            cstmt.setString(2, passwdTC);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            for (int i = 0; i < cols; i++) {
                String name = md.getColumnLabel(i + 1);
                print(name + "\t");
            }

            println("");
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    String value = rs.getString(i + 1);
                    print(value + "\t");
                }
                println("");
            }

            System.out.println( "Hello World!" );
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void print(String cOut) {
        System.out.print(cOut);
    }
    private static void println(String cOut) {
        System.out.println(cOut);
    }

    public static int[] getDivisibleNumbers(int[] numbers, int divider) {
        int[] result = new int[]{0};
        int len = 0;

        for (int nElem :numbers) {
            if ((nElem % divider) == 0 && nElem > 0) {
                if (len == 0) {
                    result = new int[]{nElem};
                    len++;
                } else {
                    // AADD
                    int[] aTmp = new int[len + 1]; // создаем увеличенный размер
                    System.arraycopy(result, 0, aTmp, 0, len); // копирование в новый
                    aTmp[len] = nElem; // обновляем последний элемент
                    result = aTmp; // замена ссылки
                    len++;
                }
            }
        }
        return result;
    }

    static char[] removeLetter01(String cStr) {
        char[] aChars =  new char[0];
        if (cStr == null) {
            return aChars;
        }

        String cAddStr;
        aChars = cStr.toCharArray();
        for (int i = 0 ; i < aChars.length; i++) {
            if (aChars[i] == 'r' || aChars[i] == 'R') {
                aChars[i] = '!';
            } else {
                cAddStr = String.valueOf(aChars[i]).toLowerCase();
                aChars[i] = cAddStr.toCharArray()[0];
            }
        }
        return aChars;
    }
    static String[] removeLetter00(String cStr) {
        String[] aStr = new String[0];
        if (cStr == null) {
            return aStr;
        }

        int len = 0;
        String cAddStr;
        char[] cChars = cStr.toCharArray();
        for (int i = 0 ; i < cChars.length; i++) {
            if (cChars[i] == 'r' || cChars[i] == 'R') {
                cAddStr = "!";
            } else {
                cAddStr = String.valueOf(cChars[i]).toLowerCase();
            }

            if (len == 0) {
                aStr = new String[]{cAddStr};
                len++;
            } else {
                // AADD
                String[] aTmp = new String[len + 1]; // создаем увеличенный размер
                System.arraycopy(aStr, 0, aTmp, 0, len); // копирование в новый
                aTmp[len] = cAddStr; // обновляем последний элемент
                aStr = aTmp; // замена ссылки
                len++;
            }

        }
        return aStr;
    }

}
