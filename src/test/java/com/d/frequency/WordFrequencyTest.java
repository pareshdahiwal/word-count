package com.d.frequency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

class WordFrequencyTest {


    @Test
    void findFrequencyByWords() throws IOException {
        // given
        File f = new File("build/resources/test/word-count-test.txt");
        System.out.println("FilePath: " + f.toPath() + " | " + f.getAbsolutePath());
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("Paresh", 3l);
        expected.put("Hello", 2l);
        expected.put("Callum", 2l);
        expected.put("here", 1l);

        // when
        Map<String, Long> actual = new WordFrequency().findInFiles(f.toPath());

        // Expected
        Assertions.assertEquals(expected, actual);

    }
}