package src.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {

    private static File newFile = null;
    private static String fileName = "simulation.txt";
    private static FileWriter fileWriter = null;
    private static PrintWriter printWriter = null;

    public static void createFile() {
        try {
            newFile = new File(fileName);
            newFile.createNewFile();
        } catch (Exception e) {
            System.out.println("error creating");
        }
    }
    
  
    public static void writeToFile(String message) {
        try {
            if (fileWriter == null)
                fileWriter = new FileWriter(fileName);
            if (printWriter == null)
                    printWriter = new PrintWriter(fileWriter);
            printWriter.write(message);
            
        } catch (Exception e) {
            System.out.println("error writing");
        }
    }

    public static void closeWriter() {
        try {
            if (fileWriter != null)
                fileWriter.close();
        } catch (IOException e) {
            System.out.println("error closing");
            e.printStackTrace();
        }
    }
}