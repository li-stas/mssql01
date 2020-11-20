package com.lista;

public class Car {
    private String model;
    private int year;
    private int price;

    public Car() {
    }

    public Car(String model, int year, int price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getSuccessRate(String statistic) {
        if (statistic.length() == 0) {
            return 0;
        }
        // write your code here
        int cntSuccess = 0;
        char[] cChars = statistic.toCharArray();
        for (char cChr: cChars) {
            if (cChr == '1') {
                cntSuccess++;
            }
        }
        return (double) cntSuccess / cChars.length;
    }
    public String getValue(String dataFromDatabase) {
        int nBeg = dataFromDatabase.indexOf("=") + 1;
        return dataFromDatabase.substring(nBeg).toLowerCase();

    }

    public boolean isWerewolf(String target) {
        boolean lRet = true;
        StringBuffer cbOut = new StringBuffer();
        String cOut = "";
        char[] cChars = target.toCharArray();
        for (int i = cChars.length - 1; i >= 0; i--) {
            cbOut.append(cChars[i]);
        }
        cOut = cbOut.toString();
        lRet = cbOut.equals(cOut);
        return lRet;
    }
    public String makeAbbr(String fullName) {
        if (fullName == null) {

        }
        StringBuffer cbOut = new StringBuffer();
        char[] cChars = fullName.toCharArray();
        for (int i = 0 ; i < cChars.length; i++) {
            if (i == 0) {
                cbOut.append(cChars[i]);
            }
            if (cChars[i] == ' ') {
                i++;
                cbOut.append(cChars[i]);
            }
        }
        return cbOut.toString().toUpperCase();
    }

    /*for (int i = 0; i < statistic.length(); i++) {
            if (statistic[i] = ) {

            }

        }
*/
}
