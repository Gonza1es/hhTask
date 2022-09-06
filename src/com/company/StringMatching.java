package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StringMatching {

    public void run() {                                                                                         //Начало работы основного алгоритма
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        inputAndOutputFile(path.replace("\\","\\\\"));                                          //Приведение введенного пути к файлу в необходимый формат и вызов функции ввода/вывода значений
        scanner.close();
    }

    private void inputAndOutputFile(String path) {
        try {
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
                    similarStrings = matching(firstArray, secondArray);
                } else {
                    similarStrings = matching(secondArray, firstArray);
                }
                for (String s : similarStrings) {
                    writer.write(s+"\n");
                }
            }

            fileScan.close();
            writer.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> matching(String[] firstArray, String[] secondArray) {    //Метод, осуществляющий сравнение строк и определение наиболее похожих из них
        HashMap<Integer, String> similarityScore = new HashMap<>();            //Таблица сходства строк из второго множество относительно выбранного элемента первого множества, где
        Set<String> intersection = new HashSet<>();                            // key - количество совпадений, value - строка из второго множества, с которой происходило сравнение
        ArrayList<String> result = new ArrayList<>();
        for (String s : firstArray) {                                           //Цикл по всем элементам первого множества
            Set<String> subsetOfWordsFromFirstArray = stringToSubset(s);        //Инициализация подмножества из некоторых элементов строки
            for (String value : secondArray) {                                  //Цикл по всем элементам второго множества
                intersection.addAll(subsetOfWordsFromFirstArray);
                Set<String> subsetOfWordsFromSecondArray = stringToSubset(value);
                intersection.retainAll(subsetOfWordsFromSecondArray);           //Сравнение подмножеств слов первого и второго множества с помощью операции перечения множеств
                similarityScore.put(intersection.size(), value);
                intersection.clear();
                subsetOfWordsFromSecondArray.clear();
            }
            Integer maxSimilarityScore = Collections.max(similarityScore.keySet());  //Нахождение максимального количества совпадений со строками
            if (maxSimilarityScore != null) {
                if (maxSimilarityScore == 0) {
                    result.add(s + ":?");
                } else {
                    result.add(s + ":" + similarityScore.get(maxSimilarityScore));
                }
            }
            subsetOfWordsFromFirstArray.clear();
            similarityScore.clear();
        }
        return result;
    }


    private Set<String> stringToSubset(String word) {                               //Метод разбиения строки на множество элементов этой строки
        Set<String> result = new HashSet<>();
        String[] splitString= word.split(" ");                                //Исключаем пробелы из строки
        for (String s : splitString) {
            for (int i = 3; i < s.length(); i++) {
                result.add(s.substring(0, i));                                      //Из каждого оставшегося слова формируем множество элементов строки по правилу:
            }                                                                       //min длина элемента - 3 символа.
        }
        return result;
    }


}
