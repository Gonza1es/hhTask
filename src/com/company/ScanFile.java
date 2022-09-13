package com.company;

import com.company.interfaces.Scanning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanFile implements Scanning {

    @Override
    public File loadFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        File file = new File(path.replace("\\", "\\\\"));
        scanner.close();
        return file;
    }

    @Override
    public ArraysFromFile inputFile(File file) {
        try {
            Scanner fileScan = new Scanner(file);
            int countN = Integer.parseInt(fileScan.nextLine());
            String[] firstArray = new String[countN];

            for (int i = 0; i < countN; i++) {
                firstArray[i] = fileScan.nextLine();
            }

            int countM = Integer.parseInt(fileScan.nextLine());
            String[] secondArray = new String[countM];

            for (int i = 0; i < countM; i++) {
                secondArray[i] = fileScan.nextLine();
            }

            fileScan.close();
            return new ArraysFromFile(firstArray, secondArray);
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void outputFile(ArrayList<String> similarStrings) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (String s : similarStrings) {
                writer.write(s + "\n");
            }
            System.out.println("The program has been completed");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
