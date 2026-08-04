package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Java_notebadReader {

	public static void main(String[] args) {
		
		try {
            File file = new File("src/test/java/resources/notebad_read.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



	}

}
