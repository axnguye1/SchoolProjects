import java.io.FileWriter;
import java.io.*;
import java.util.*;
/*
4125
partner: Trieu Huynh
 */
public class ReadData {
    public static void main(String[] args) {
        //accept command line argument
        /*will be the table name ot record and insert into
        run $java Phase3 animal ; could will read animal.txt
        hint: string placeholders like %s.txt
         */

        /*datatypes should be formatted correctly, do not hardcode!
        a) numbers and floats dont use single quotes DONE
        b) string use single quotes DONE
        c) consider NULL values now, NULL values do not use single quotes DONE
         */
        if (args.length != 1) {
            System.out.println("Please pass a table name with '$ java ReadData.java (tablename)'");
            return;
        }

        String tableName = args[0];
        String fileName = tableName + ".txt";
        String outputFileName = tableName + ".sql"; //reads passed data in command line ... can be anything, not just animal
        System.out.println("File name: " + fileName);     // passed data creates an output file for the passed table.

        try (Scanner scanner = new Scanner(new File(fileName)); //same function as phase1, this try/catch reads and writes the file
             FileWriter fileWriter = new FileWriter(outputFileName)) { //uses parseData, created same way from phase1 to see if its a number or string.

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(", ");

                // Generate SQL INSERT statement
                StringBuilder insertStatement = new StringBuilder("INSERT INTO ");
                insertStatement.append(tableName).append(" VALUES (");

                for (int i = 0; i < values.length; i++) {
                    if (i > 0) {
                        insertStatement.append(", ");
                    }
                    if ("NULL".equalsIgnoreCase(values[i])){
                        insertStatement.append("NULL"); //Null gets filtered here.
                    }
                    else if (ParseData(values[i])) {
                        insertStatement.append(values[i]);
                    } else {
                        String trimmedValue = values[i].trim();
                        String escapedValue = trimmedValue.replace("'", "''");
                        insertStatement.append("'").append(escapedValue).append("'");
                    }
                }

                insertStatement.append(");");
                fileWriter.write(insertStatement.toString() + "\n");
                System.out.println(insertStatement.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper function to check if a string is numeric
    private static boolean ParseData(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
