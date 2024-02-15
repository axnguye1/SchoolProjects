import java.io.FileWriter;
import java.io.*;
import java.util.*;

public class FileEval {
    public static void main(String[] args){
       try {
           FileWriter outfile = new FileWriter("output.txt");

           File infile = new File("phase1_fall2023-1.txt");

           Scanner input = new Scanner(infile);
           while (input.hasNextLine()) { //while there's a line to read
               String line = input.nextLine(); //store that line in a String variable
               if (line.length() == 0) { //if the line doesn't have any info, skip it.
                   outfile.write("\n");
               }
               else {
                   outfile.write(processLine(line)); //write our data processing to the outfile
               }
           }
           outfile.close(); // close the outfile
           input.close(); // close the input file
       } catch(FileNotFoundException e) {
           System.out.println(e.getMessage());
       } catch (IOException e){
        System.out.println(e.getMessage());
        }//end catch

    }//end main
    public static String processLine(String line) {
        String output;
        ArrayList<String> cleanValues = new ArrayList<String>();
        String[] values = line.split(", ");
        for (String value : values) {
            cleanValues.add(ParseData(value));//call parseData()
           // cleanValues.add(value.trim());

        }
        output = String.join(", ", cleanValues);

        return output + "\n";
    }
    public static String ParseData(String value) {
        try {
             Integer.parseInt(value);
            return "Integer";
        } catch (NumberFormatException e1) {
            try {
                Float.parseFloat(value);
                return "Float";
            } catch (NumberFormatException e2) {
                return "String";
            }
        }
    }

}