package utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;

public class UniqueWordsCalculation {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/inputFile.txt";
        String outputFilePath = "src/main/resources/outputFile.txt";

        try {
            // Read text from file
            String text = FileUtils.readFileToString(new File(inputFilePath),"UTF-8");

            // Split text into words
            String[] words = StringUtils.split(text);

            // Calculate unique word count
            int uniqueWordCount = countUniqueWords(words);

            // Write the result to file
            FileUtils.writeStringToFile(new File(outputFilePath), "Total number of unique words: " + String.valueOf(uniqueWordCount),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countUniqueWords(String[] words) {
        int uniqueWordCount = 0;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (StringUtils.equals(currentWord, words[j])) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueWordCount++;
            }
        }
        System.out.println("Successfully wrote to the output file");
        return uniqueWordCount;
    }
}