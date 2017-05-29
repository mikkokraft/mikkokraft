

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author mikko
 */
public class Gatherer {
    
    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
    
    public static String filesToString(String[] filenames) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        String contents;
        for(String filename : filenames) {
            contents = new Scanner(new File(filename)).useDelimiter("\\Z").next();
            stringBuilder.append(contents);
        }
        return stringBuilder.toString();
    }    
    public static String fileToString(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename)).useDelimiter("\\Z").next();
    }
    
    private static void writeToFile(String input, String output) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(input);
        }
    }
    
    public static String createShelf(String start, String[] items, String end) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        String contents; 
        for (String item : items) {
            stringBuilder.append(start);
            contents = new Scanner(new File(item)).useDelimiter("\\Z").next();
            stringBuilder.append(contents);
            stringBuilder.append(end);
        }
        return stringBuilder.toString();
    }
    
    
    //Expecting input of:
    //0: beginning of shelf item file
    //1: shelf items file list
    //2: end of shelf item file
    //3: shelf output file
    //4: main tasklist
    //5: output file
    public static void main(String[] args) throws IOException {
        
	System.out.println("starting...");
    
        //1st generate shelf:
        String startShelfItem = fileToString(args[0]);
        String endShelfItem = fileToString(args[2]);
        String[] shelfTasklist = readLines(args[1]);
        String shelf = createShelf(startShelfItem, shelfTasklist, endShelfItem);
        writeToFile(shelf, args[3]);
        
        //2nd generate whole index:
        String[] mainTasklist = readLines(args[4]);
        String index = filesToString(mainTasklist);
        writeToFile(index, args[5]);   
	
	System.out.println("ending...");  
    }

    
    
}