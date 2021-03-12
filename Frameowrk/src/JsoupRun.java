
import java.io.IOException;

import org.jsoup.select.Elements;

public class JsoupRun {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Website top = new Website("https://euw.op.gg/summoner/userName=ZPG+riddEr","span.Name",false);
		Website web = new Website("https://euw.op.gg/summoner/userName=ZPG+riddEr",null, false);
		
		
	    //Website.selection("span.Name");
	    String x = Website.selection("div.WinRatioTitle");
	    String y = Website.selection("span.Name");
		
		Creator.writeToFile(top);
		
		Creator.writeContent(x);
		Creator.writeContent(y);
		
	}


		

	
	
	
}

