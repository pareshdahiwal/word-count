package com.d;

import com.d.frequency.WordFrequency;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0 || args[0] == null) {
            System.out.println("Arguments missing. Expected fileName along with the path as first argument... e.g. java -jar \"c:\\myfile.txt\"");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Error: File not found. File: " + file.getAbsolutePath());
            System.exit(0);
        }

        System.out.println("Below are all the words with their frequencies in file: " + args[0]);
        System.out.println("---------------------------------------------------------------------");

        Map<String, Long> frequencyByWords = new WordFrequency().findInFiles(file.toPath());
        frequencyByWords.entrySet().forEach(System.out::println);
    }
}