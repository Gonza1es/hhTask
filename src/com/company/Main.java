package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ScanFile scanFile = new ScanFile();
        StringMatching matching = new StringMatching();
        File file = scanFile.loadFile();
        ArraysFromFile arrays = scanFile.inputFile(file);
        ArrayList<String> result = matching.matchingAlgorithm(arrays.getFirstArray(), arrays.getSecondArray());
        scanFile.outputFile(result);
    }
}
