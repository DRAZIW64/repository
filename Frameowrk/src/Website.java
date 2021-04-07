import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Website {

			
			static String url;
			String prop;
			String str;
			static ArrayList<String> list = new ArrayList<String>();
			static ArrayList<String> topic = new ArrayList<String>();
			static Document scrape;
			public static String scrapeSelection;
			public static String fileTitle;
			
			
			public static void getSite(String url) throws IOException {
				Document scrape = Jsoup.connect(url).timeout(3000).get();
				String title = scrape.title();
				fileTitle = title;
				Website.url = url;
				Website.scrape = scrape;
			}
			public static String selection(String selector) throws IOException {
				
				Elements scrapeSelection = scrape.select(selector);
				//System.out.println(scrapeSelection);
				String select;
				Website.url = url;
				select = selector;
				if (select.equals("img")) {
					Element imageElement = scrape.select("img").first();
					String AbsoluteUrl = imageElement.absUrl("src");
					String srcValue = imageElement.attr("src"); 
					
					InputStream in = null;
					OutputStream out = null;
					try {
						URL pUrl = new URL(AbsoluteUrl);
						String z = pUrl.toString();
						File file = new java.io.File("C:\\Users\\riddm\\git\\repository\\Frameowrk\\src\\" + fileTitle + ".html");
						file.getParentFile().mkdirs();
						if (!file.exists()) {
						    file.createNewFile();
						} 
						String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
						URLConnection con = pUrl.openConnection();
						con.setRequestProperty("User-Agent", USER_AGENT);
						in = con.getInputStream();
						out = new FileOutputStream("C:\\Users\\riddm\\git\\repository\\Frameowrk\\src\\" + fileTitle + "2" + ".jpg");
						byte[] buffer = new byte[2048];
						int length;
						while ((length = in.read(buffer)) != -1) {
							out.write(buffer, 0, length);
						}
					}
					catch(Exception e) {
						System.out.println(e);
					}
					in.close();
					out.close();
					return select;
				}
				else {
				list.add(scrapeSelection.toString());
				return scrapeSelection.toString();
				
				}
				
			}
			public static ArrayList<String> returnTitle(String title) {
				topic.add(title);
				return topic;
			}

}


