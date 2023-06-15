package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.surefire.shared.compress.harmony.unpack200.SegmentUtils;
import org.apache.maven.surefire.shared.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class CalculateUniqueWords {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger(CalculateUniqueWords.class);

        File sourceFile = new File("src/main/resources/inputFile.txt");
        File targetFile = new File("src/main/resources/outputFile.txt");
        try {
            String str = Files.readString(sourceFile.toPath());
            str = str.toLowerCase();
            str = str.replaceAll("[^a-z\\s]", "")
                    .replace("\n", " ")
                    .replace("\r", " ");
            String[] allWords = str.split(" ");
            Set<String> wordSet = new HashSet<>(Arrays.asList(allWords));
            wordSet.remove("");
            FileUtils.writeLines(targetFile, Collections.singleton("Number of unique words in the input file is: "
                    + wordSet.size() +"\n" + wordSet));
            logger.info("Successfully wrote to the file.");
        } catch (IOException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }
    }
}