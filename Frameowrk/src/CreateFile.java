import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.select.Elements;

public class CreateFile {
	
	public CreateFile() {
	    try {
		      File myObj = new File("filename.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());		        
		      } else {
		        System.out.println("File already exists.");

		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}