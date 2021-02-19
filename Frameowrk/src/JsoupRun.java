import org.jsoup.Jsoup;
import java.io.File;
import java.io.FileWriter;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class JsoupRun {

	public static void main(String[] args) throws IOException {
		
		//URL ENTRY
		Document doc = Jsoup.connect("https://euw.op.gg/summoner/userName=kofolac")
				.timeout(6000).get();
		//System.out.println(doc);
		ArrayList<String> ar = new ArrayList<String>();
		//int count = 0;
		
		
		//SCRAPING SELECTION // 
		Elements name = doc.select("span.Name");
		//System.out.println(name.text());
		String savefile = name.text();
		//System.out.println(savefile);
		
		Elements profpic = doc.select("div.ProfileIcon");
		//System.out.println(profpic.select("img"));
		
		Elements maintier = doc.select("div.Tierbox.Box");
		Elements subtier = doc.select("div.sub-tier");
		//System.out.println(maintier.select("img"));
		
		Elements wratio = doc.select("div.WinRatioTitle");
		//System.out.println(wratio);	
		
		Elements champions = doc.select("div.MostChampionContent");
		for (Element e : champions.select("div.ChampionBox.Ranked")) {
			int number;
			//System.out.println(e.text());
			//System.out.println(e.select("a").text());
			String played = e.select("a").text();
			System.out.println(played);
			ar.add(played);
			Document docTwo = Jsoup.connect("https://u.gg/lol/champions/"+played+"/build")
					.timeout(6000).get();
			Elements Uname = docTwo.select("div.champion-header-info");
			
			System.out.println("Test" + Uname.select("span.champion-name").text());
			
			
			//count = (count+1);
			//System.out.println(count);
		}
		
		//for(int k = 0; k < 5; k++) { 
		//	System.out.println(ar);
		//Document docTwo = Jsoup.connect("https://u.gg/lol/champions/"+ar+"/build")
		//		.timeout(6000).get();
		//Elements Uname = docTwo.select("div.champion-header-info");
		//ar.remove(0);
			
			
		//}
		
		//System.out.println(docTwo);
		//System.out.println("Test" + Uname + "ASDF");
		

		
		
		//FILEWRITING 
		FileWriter myWriter = new FileWriter(savefile + ".txt");
		FileWriter htmlWriter = new FileWriter(savefile + ".html");
		FileWriter csvWriter = new FileWriter(savefile + ".csv");
		
		//TESTING
		try {
		      File myObj = new File(savefile);
		      if (myObj.createNewFile()) {
		    	
		    	myWriter.write(profpic.toString() + wratio.toString());
		  		myWriter.close();
		  		
		  		
		  		htmlWriter.write(name.toString() + profpic.toString() + wratio.toString());
		  		htmlWriter.close();
		  		
		  		
		  		csvWriter.write(profpic.toString() + wratio.toString());
		  		csvWriter.close();
		        System.out.println("File created: " + myObj.getName());		        
		      
		      } else {
		    	myWriter.write(profpic.toString() + wratio.toString());
		  		myWriter.close();
		  		
		  		
		  		htmlWriter.write(name.toString() + profpic.toString() + wratio.toString());
		  		htmlWriter.close();
		  		
		  		
		  		csvWriter.write(profpic.toString() + wratio.toString());
		  		csvWriter.close();
		        System.out.println("Filename already exists. Content updated.");

		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	
	}


	
}

