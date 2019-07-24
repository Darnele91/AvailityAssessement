package Second;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public static void main(String[] args) {

        File file  = new File("random.csv");
        File output = new File("output.csv");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String currentLine = " ";

        try {

        	java.io.FileReader fr = new java.io.FileReader(file);
        	reader = new BufferedReader(fr);
        	 ArrayList<Enrollee> enrollementRecords = new ArrayList<Enrollee>();
       
            while ((currentLine = reader.readLine()) != null) {
                String[] enrollementDetails = currentLine.split(",");
                String insurance = enrollementDetails[0];
                int id = Integer.valueOf(enrollementDetails[1]);
                String name = enrollementDetails[2];
                int version = Integer.valueOf(enrollementDetails[3]);
                
                enrollementRecords.add(new Enrollee(insurance, id, name, version));
                currentLine = reader.readLine();

            }
            java.io.FileWriter fw = new java.io.FileWriter(output);
             writer = new BufferedWriter(fw);
             for(Enrollee enrollee : enrollementRecords) {
            	 writer.write(enrollee.insurance);
            	 writer.write(enrollee.ID);
            	 writer.write(enrollee.name);
            	 writer.write(enrollee.version);
            	 writer.newLine();
             }

             reader.close();
             writer.close();
             
        } catch (FileNotFoundException e) {
        	System.out.println("File not found, program will exit now");
        	System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                	reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
}
