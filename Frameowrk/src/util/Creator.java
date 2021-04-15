import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Creator {
	public void returnArray() {
		//System.out.println(Website.list);
	}
	public static void createHtmlName(String x) throws IOException{
		String t = Website.fileTitle;
		FileWriter htmlwrite = new FileWriter("src/" + t + ".html");
		htmlwrite.close();
	}

	public static void writeContent(String scrapeSelection) throws IOException{
		PrintWriter pw = null;
		//System.out.println("Content initiated");
		
		String t= Website.fileTitle;
		String x = scrapeSelection;
		try {
		File file = new File("src/" + t + ".html");
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
