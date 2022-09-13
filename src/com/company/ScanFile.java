package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanFile {

    public void run() {                                                                                         //Начало работы основного алгоритма
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        inputAndOutputFile(path.replace("\\","\\\\"));                                          //Приведение введенного пути к файлу в необходимый формат и вызов функции ввода/вывода значений
        scanner.close();
    }

    private void inputAndOutputFile(String path) {
        try {
            StringMatching stringMatching = new StringMatching();
            Scanner fileScan = new Scanner(new File(path));
            FileWriter writer = new FileWriter("output.txt");
            ArrayList<String> similarStrings;
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

            if (countN == countM && countN == 1) {
                writer.write(firstArray[0] + ":" + secondArray[0]);
            } else {
                if (countN >= countM) {
                    similarStrings = stringMatching.matching(firstArray, secondArray);
                } else {
                    similarStrings = stringMatching.matching(secondArray, firstArray);
                }
                for (String s : similarStrings) {
                    writer.write(s+"\n");
                }
            }
            System.out.println("The program has been completed");
            fileScan.close();
            writer.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
