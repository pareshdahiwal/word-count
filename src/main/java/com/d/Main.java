package com.d;

import com.d.frequency.WordFrequency;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Inside main()...");
        if (args.length == 0 || args[0] == null) {
            System.out.println("Arguments missing. Expected fileName along with the path as first argument... e.g. java -jar \"c:\\myfile.txt\"");
            System.exit(0);
        }
        System.out.println("You have passed file: " + args[0]);

        File file = new File(args[0]);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Error: File not found. File: " + file.getAbsolutePath());
            System.exit(0);
        }

        Map<String, Long> frequencyByWords = new WordFrequency().findInFiles(file.toPath());
        frequencyByWords.entrySet().forEach(System.out::println);
    }
}