import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Creator {
	public void returnArray() {
		System.out.println(Website.list);
	}
	public static void writeToFile(Website web) throws IOException{
		ArrayList<String> title = Website.topic;
		FileWriter htmlwrite = new FileWriter("src/" + title + ".html");
		htmlwrite.close();
	}

	public static void writeContent(String scrapeSelection) throws IOException{
		PrintWriter pw = null;
		System.out.println("Content initiated");
		ArrayList<String> title = Website.topic;
		String x = scrapeSelection;
		try {
		File file = new File("src/" + title + ".html");
		FileWriter fw = new FileWriter(file, true);
		pw = new PrintWriter(fw);
		
			pw.write(x);
		
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
