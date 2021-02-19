import org.jsoup.Jsoup;
import java.io.File;
import java.io.FileWriter;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.View;

public class JsoupRun {

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//URL ENTRY
		Document doc = Jsoup.connect("https://euw.op.gg/summoner/userName=ZPG+Thornight")
				.timeout(6000).get();
		//System.out.println(doc);
		ArrayList<String> ar = new ArrayList<String>();
		ArrayList<String> wr = new ArrayList<String>();
		ArrayList<String> ant = new ArrayList<String>();
		
		
		//SCRAPING SELECTION // 
		Elements name = doc.select("span.Name");
		//System.out.println(name.text());
		String savefile = name.text();
		//System.out.println(savefile);

		//Elements profpic = doc.select("div.ProfileIcon");
		//System.out.println(profpic.select("img"));
		
		Elements maintier = doc.select("div.Tierbox.Box");
		Elements mtier = maintier.select("div.TierRank");
		Elements subtier = doc.select("div.sub-tier");
		Elements subt = subtier.select("div.sub-tier__rank-tier");
		//System.out.println(subt.text());
		//System.out.println(maintier.select("img"));
		
		Elements wratio = doc.select("div.WinRatioTitle");
		//System.out.println(wratio);	
		
		
		Elements champions = doc.select("div.MostChampionContent");
		for (Element e : champions.select("div.ChampionBox.Ranked")) {
			//System.out.println(e.text());
			//System.out.println(e.select("a").text());
			String percent = e.select("div.WinRatio").text();
			String played = e.select("a").text();
			String ant1 = e.select("div.Title").text();
			System.out.println(played);
			ar.add(played);
			wr.add(percent);
			ant.add(ant1);
						//System.out.println("Test" + Uname.select("span.champion-name").text());
		}
		
		Document ugg = Jsoup.connect("https://u.gg/lol/champions/"+ ar.get(0)+"/build?rank=challenger")
				.timeout(6000).get();
		System.out.println(ar.get(0));
		Elements uggwinrate = ugg.select("div.win-rate.shinggo-tier");
		Elements uggperswinrate = uggwinrate.select("div.value");
				//System.out.println(uggwinrate.text());
				Elements uggvsrate = ugg.select("div.overall-rank");
				Elements uggpervsswinrate = uggvsrate.select("div.value");
						//System.out.println(uggwinrate.text());
					Elements uggpickrate = ugg.select("div.pick-rate");
					Elements uggperpickswinrate = uggpickrate.select("div.value");
							//System.out.println(uggwinrate.text());
						Elements uggbankrate = ugg.select("div.ban-rate");
					
		//FILEWRITING 
		//FileWriter myWriter = new FileWriter(savefile + ".txt");
		FileWriter htmlWriter = new FileWriter(savefile + ".html");
		//FileWriter csvWriter = new FileWriter(savefile + ".csv");
		
		//TESTING
		htmlWriter.write("<h1> Summoner name: </h1>" + name.toString() + "</br>");
		htmlWriter.write("SoloQue Division: " + mtier + "</br>" + "FlexQue Division: " + "</br>" + subt.text() + "</br>");
		htmlWriter.write("<h2> Your top champions: </h2>" + "</br>");
		for(int i=0; i<ar.size(); i++) {
			htmlWriter.write(ar.get(i) + " - " + wr.get(i) + " - " + ant.get(i) + " - "  + "</br>");
			
		}	
		htmlWriter.write("<h2> Global stats on your main champion: </h2>" + "</br>");
		htmlWriter.write("<h3>" + ar.get(0) + "</h3>");
		htmlWriter.write(uggwinrate.text() + "</br> " + uggvsrate.text() + "</br> " + uggpickrate + "</br>" + uggbankrate);
		
		
		htmlWriter.close();  		
		}

	

	
	
}

