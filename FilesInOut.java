import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Enter Input file
        System.out.println("Enter input file name:");
        String inputFileName = in.nextLine();
        // Enter Output file
        System.out.println("Enter output file name:");
        String outputFileName = in.nextLine();
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                // format name
                StringBuilder formattedName = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    String formattedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase().replaceAll("\\d", "");
                    formattedName.append(i == 0 ? formattedWord : " " + formattedWord);
                }
                // format date
                String dateString = line.substring(line.lastIndexOf(" ") + 1);
                String formattedDate = dateString.substring(0, 2) + "/" + dateString.substring(2, 4) + "/" + dateString.substring(4);
                // write formatted output to file
                writer.println(formattedName + " " + formattedDate);
            }
            System.out.println("The file has been formatted!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} // FilesInOut
