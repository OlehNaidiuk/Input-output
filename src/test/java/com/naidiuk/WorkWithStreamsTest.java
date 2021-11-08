package com.naidiuk;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class WorkWithStreamsTest {

    @Test
    void testCountTheNumberOfChars() {
        //Prepare
        Path path = Path.of("src\\Test.txt");

        //When
        int counter = WorkWithStreams.countTheNumberOfChars(path);

        //Then
        assertEquals(28, counter);
    }

    @Test
    void testCountTheWords() {
        //Prepare
        Path path = Path.of("src\\Test.txt");

        //When
        int counter = WorkWithStreams.countTheWords(path);

        //Then
        assertEquals(6, counter);
    }

    @Test
    void testCountTheSentences() {
        //Prepare
        Path path = Path.of("src\\План - капкан.txt");

        //When
        int counter = WorkWithStreams.countTheSentences(path);

        //Then
        assertEquals(12, counter);
    }

    @Test
    void testCopyImage() {
        //Prepare
        Path pathToImage = Path.of("src\\LWlRSlZDWoE.jpg");
        Path targetPath = Path.of("src\\yourPictureCopy.jpg");

        //When
        WorkWithStreams.copyImage(pathToImage, targetPath);

        //Then
        assertTrue(Files.exists(targetPath.getFileName()));
    }

    @Test
    void testCountTheSyllables() {
        //Prepare
        Path pathToEnglishText = Path.of("src\\English text.txt");

        //When
        int counter = WorkWithStreams.countTheSyllables(pathToEnglishText);

        //Then
        assertEquals(44, counter);
    }
}