 
import java.io.IOException;

import org.jsoup.select.Elements;

public class ScrapeMain {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		

		//Scrape entire site
		Website.getSite("https://euw.op.gg/summoner/userName=zpg+ridder");
		
		//Testing return without string attached
		Website.selection("body");
	   
		//Select content from scrape
	    String x = Website.selection("div.WinRatioTitle");
	    String y = Website.selection("span.Name");
		
	    //Create the HTML file
	    Creator.createHtmlName(y);
		
	    //Write content to HTML file
	    Creator.writeContent(x);
		
	}


		

	
	
	
}

