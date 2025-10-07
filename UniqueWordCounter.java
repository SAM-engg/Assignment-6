import java.io.*;
import java.util.*;

public class UniqueWordCounter {


    public static void countUniqueWords(String filePath) {
        Set<String> hashSet = new HashSet<>();  // For Task A (unique count)
        Set<String> treeSet = new TreeSet<>();  // For Task B (sorted words)

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();


                String[] words = line.split("\\s+");


                for (String word : words) {
                    if (!word.isEmpty()) {
                        hashSet.add(word);
                        treeSet.add(word);
                    }
                }
            }


            System.out.println("🔹 TASK A: Count Unique Words");
            System.out.println("Total unique words: " + hashSet.size());
            System.out.println();


            System.out.println("🔹 TASK B: List Unique Words Alphabetically");
            System.out.println("Unique words in alphabetical order:\n");
            for (String word : treeSet) {
                System.out.println(word);
            }

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        String filePath = "app.txt";

        System.out.println(" Unique Word Counter Program Started\n");
        countUniqueWords(filePath);
        System.out.println("\n Program Completed Successfully!");
    }
}
