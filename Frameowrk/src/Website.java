import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Website {

			
			String url;
			String prop;
			String str;
			static ArrayList<String> list = new ArrayList<String>();
			static ArrayList<String> topic = new ArrayList<String>();
			static Document scrape;
			public static String scrapeSelection;
			
			
			Website(String url, String prop, Boolean text) throws IOException{
			
			this.url = url;
			this.prop = prop;
			
			//Initial scrape
			Document scrape = Jsoup.connect(url).timeout(3000).get();
			String title = scrape.title();	
			Website.scrape = scrape;
			//User selection
			if(prop != null)
			{
				if(text) {
					Elements partial = scrape.select(prop);	
				}
				else {
					Elements partial = scrape.select(prop);
					returnTitle(title);
					str = partial.toString();
				}	
			}
			else
			{
				if(text) {
					//System.out.println(scrape.text());
				}
				else {
					//System.out.println(scrape);
					
				}
			}
			
			
			
			}	
			
			public static String selection(String selector) {
				Elements scrapeSelection = scrape.select(selector);
				System.out.println(scrapeSelection);
				list.add(scrapeSelection.toString());
				return scrapeSelection.toString();
				
			}
			
			public static ArrayList<String> returnTitle(String title) {
				topic.add(title);
				return topic;
			}

}


