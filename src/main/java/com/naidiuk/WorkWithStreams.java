package com.naidiuk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithStreams {

    public static int countTheNumberOfChars(Path path) {
        int charsCounter = 0;
        try (InputStream streamFromFile = Files.newInputStream(path);
             InputStreamReader readStreamFromFile = new InputStreamReader(streamFromFile);
             BufferedReader streamFromBuffer = new BufferedReader(readStreamFromFile))
        {
            StringBuilder fileContents = new StringBuilder();
            while (streamFromBuffer.ready()) {
                fileContents.append(streamFromBuffer.readLine());
            }
            char[] chars = fileContents.toString().toCharArray();
            for (char aChar : chars) {
                charsCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charsCounter;
    }

    public static int countTheWords(Path path) {
        int wordsCounter = 0;
        try (InputStream streamFromFile = Files.newInputStream(path);
             InputStreamReader readStreamFromFile = new InputStreamReader(streamFromFile);
             BufferedReader streamFromBuffer = new BufferedReader(readStreamFromFile))
        {
            while (streamFromBuffer.ready()) {
                String fileContents = streamFromBuffer.readLine();
                String[] words = fileContents.split("\\s");
                for (String word : words) {
                    if (!"-".equals(word)) {
                        wordsCounter++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsCounter;
    }

    public static int countTheSentences(Path path) {
        int sentencesCounter = 0;
        try (InputStream streamFromFile = Files.newInputStream(path);
             InputStreamReader readStreamFromFile = new InputStreamReader(streamFromFile);
             BufferedReader streamFromBuffer = new BufferedReader(readStreamFromFile))
        {
            while (streamFromBuffer.ready()) {
                streamFromBuffer.readLine();
                sentencesCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentencesCounter;
    }

    public static void copyImage(Path sourcePath, Path targetPath) {
        try (InputStream streamFromFile = Files.newInputStream(sourcePath)) {
            if (Files.notExists(targetPath)) {
                Files.createFile(targetPath);
            }
            try (OutputStream streamToFile = Files.newOutputStream(targetPath)) {
                byte[] buffer = new byte[20480];
                while (streamFromFile.available() > 0) {
                    int real = streamFromFile.read(buffer);
                    streamToFile.write(buffer, 0, real);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countTheSyllables(Path path) {
        int syllablesCounter = 0;
        try (InputStream streamFromFile = Files.newInputStream(path);
             InputStreamReader readStreamFromFile = new InputStreamReader(streamFromFile);
             BufferedReader streamFromBuffer = new BufferedReader(readStreamFromFile))
        {
            while (streamFromBuffer.ready()) {
                String fileContents = streamFromBuffer.readLine();
                String[] words = fileContents.split("\\W+");
                Pattern syllables = Pattern.compile("[aeiouy]+", Pattern.CASE_INSENSITIVE);
                for (String word : words) {
                    Matcher matcher = syllables.matcher(word);
                    while (matcher.find()) {
                        syllablesCounter++;
                    }
                    if (word.length() > 2) {
                        String wordEndings = word.substring(word.length() - 2);
                        System.out.println(wordEndings);
                        Pattern ending = Pattern.compile("[klnrst]e");
                        Matcher m = ending.matcher(wordEndings);
                        while (m.find()) {
                            syllablesCounter--;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return syllablesCounter;
    }
}
