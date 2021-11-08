package com.naidiuk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkWithStreams {

    public static int countTheNumberOfChars(Path path) {
        int charsCounter = 0;
        try (InputStream fromFile = Files.newInputStream(path);
             InputStreamReader reading = new InputStreamReader(fromFile);
             BufferedReader buffer = new BufferedReader(reading))
        {
            while (buffer.ready()) {
                String fileContents = buffer.readLine();
                charsCounter += fileContents.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charsCounter;
    }

    public static int countTheWords(Path path) {
        int wordsCounter = 0;
        try (InputStream fromFile = Files.newInputStream(path);
             InputStreamReader reading = new InputStreamReader(fromFile);
             BufferedReader buffer = new BufferedReader(reading))
        {
            while (buffer.ready()) {
                String fileContents = buffer.readLine();
                String[] words = fileContents.split("\\s");
                wordsCounter += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsCounter;
    }

    public static int countTheSentences(Path path) {
        int sentencesCounter = 0;
        try (InputStream fromFile = Files.newInputStream(path);
             InputStreamReader reading = new InputStreamReader(fromFile);
             BufferedReader buffer = new BufferedReader(reading))
        {
            while (buffer.ready()) {
                String fileContents = buffer.readLine();
                char[] chars = fileContents.toCharArray();
                for (char aChar : chars) {
                    if (       aChar == '.'
                            || aChar == '!'
                            || aChar == '?')
                    {
                        sentencesCounter++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentencesCounter;
    }

    public static void copyImage(Path sourcePath, Path targetPath) {
        Path absolute = targetPath.toAbsolutePath();
        String filePath = absolute + "\\yourPictureCopy.jpg";
        Path pathOfFile = Path.of(filePath);
        try (InputStream fromFile = Files.newInputStream(sourcePath)) {
            if (Files.notExists(pathOfFile)) {
                Files.createFile(pathOfFile);
            }
            try (OutputStream toFile = Files.newOutputStream(pathOfFile)) {
                byte[] buffer = new byte[65536];
                while (fromFile.available() > 0) {
                    int amountOfBytes = fromFile.read(buffer);
                    toFile.write(buffer, 0, amountOfBytes);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static int countTheSyllables(Path path) {
        int syllablesCounter = 0;
        try (InputStream fromFile = Files.newInputStream(path);
             InputStreamReader reading = new InputStreamReader(fromFile);
             BufferedReader buffer = new BufferedReader(reading))
        {
            while (buffer.ready()) {
                String fileContents = buffer.readLine();
                char[] chars = fileContents.toCharArray();
                for (char aChar : chars) {
                    if (       aChar == 'a'
                            || aChar == 'e'
                            || aChar == 'i'
                            || aChar == 'o'
                            || aChar == 'u'
                            || aChar == 'y')
                    {
                        syllablesCounter++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return syllablesCounter;
    }
}
