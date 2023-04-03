package com.d.frequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequency {

    public static final String SPECIAL_CHARACTERS_TO_BE_IGNORED = "[-.& ,+!#$%\\^*();\\/|<>\"'?=:\\t_\\n\\[\\]{}~`]";

    public Map<String, Long> findInFiles(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.map(line -> line.replaceAll(SPECIAL_CHARACTERS_TO_BE_IGNORED, " "))
                    .flatMap(Pattern.compile("\s+")::splitAsStream)
                    .filter(Predicate.not(String::isBlank))
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        }
    }

}
