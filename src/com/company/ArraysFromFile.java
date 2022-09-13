package com.company;

public class ArraysFromFile {
    private String[] firstArray;
    private String[] secondArray;

    public ArraysFromFile(String[] firstArray, String[] secondArray) {
        if (firstArray.length >= secondArray.length) {
            this.firstArray = firstArray;
            this.secondArray = secondArray;
        } else {
            this.firstArray = secondArray;
            this.secondArray = firstArray;
        }
    }

    public String[] getFirstArray() {
        return firstArray.clone();
    }

    public void setFirstArray(String[] firstArray) {
        this.firstArray = firstArray;
    }

    public String[] getSecondArray() {
        return secondArray.clone();
    }

    public void setSecondArray(String[] secondArray) {
        this.secondArray = secondArray;
    }
}
