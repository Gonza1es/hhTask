package com.company.interfaces;


import java.io.File;
import java.util.ArrayList;

public interface Scanning {
   File loadFile();

   Object inputFile(File file);

   void outputFile(ArrayList<String> similarStrings);
}
