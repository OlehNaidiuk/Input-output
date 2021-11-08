package com.naidiuk;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class WorkWithStreamsTest {

    private final Path path = Path.of("src\\Test.txt");

    @Test
    void testCountTheNumberOfChars() {
        //When
        int counter = WorkWithStreams.countTheNumberOfChars(path);

        //Then
        assertEquals(28, counter);
    }

    @Test
    void testCountTheWords() {
        //When
        int counter = WorkWithStreams.countTheWords(path);

        //Then
        assertEquals(6, counter);
    }

    @Test
    void testCountTheSentences() {
        //When
        int counter = WorkWithStreams.countTheSentences(path);

        //Then
        assertEquals(3, counter);
    }

    @Test
    void testCopyImage() {
        //Prepare
        Path pathToImage = Path.of("src\\LWlRSlZDWoE.jpg");
        Path pathToTheCopyOfTheImage = Path.of("src\\copyOfTheImage.jpg");

        //When
        WorkWithStreams.copyImage(pathToImage, pathToTheCopyOfTheImage);

        //Then
        assertTrue(Files.exists(pathToTheCopyOfTheImage));
    }

    @Test
    void testCountTheSyllables() {
        //Prepare
        Path pathToEnglishText = Path.of("src\\English text.txt");

        //When
        int counter = WorkWithStreams.countTheSyllables(pathToEnglishText);

        //Then
        assertEquals(33, counter);
    }
}