import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class Echo {
	
	public static void main(String[] args) throws IOException{
		
		Configuration config = new Configuration();
		String dicPath = "file:C:\\Users\\me\\eclipse-workspace\\VRPro\\src\\prodic.dic";
		String lmPath = "file:C:\\Users\\me\\eclipse-workspace\\VRPro\\src\\langmodel.lm";
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath(dicPath);
		config.setLanguageModelPath(lmPath);
		
		LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
		rec.startRecognition(true);
		
		SpeechResult result;
		
		while ((result = rec.getResult()) != null) {
			String cmd = result.getHypothesis();
			String comp = null;
			Process p;
			if (cmd.equalsIgnoreCase("close google")) {
                System.out.println("Google Closed!");
                comp = "taskkill /F /IM chrome.exe";
            } else if(cmd.equalsIgnoreCase("open google")) {
            	 System.out.println("Opening google");
            	comp = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
            } else if(cmd.equalsIgnoreCase("open spotify")) {
           	 	System.out.println("Opening Spotify");
           	 	comp = "C:\\Users\\Me\\AppData\\Roaming\\Spotify\\Spotify.exe";
            } else if(cmd.equalsIgnoreCase("close spotify")) {
           	 	System.out.println("Closing Spotify");
           	 	comp = "taskkill /F /IM Spotify.exe";
            } else if(cmd.equalsIgnoreCase("Go to twitter")) {
           	 	System.out.println("Going to Twitter");
           	 	comp = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe twitter.com";
            } else if(cmd.equalsIgnoreCase("Go to reddit")) {
           	 	System.out.println("Going to Reddit");
           	 	comp = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe reddit.com";
            } else if(cmd.equalsIgnoreCase("Go to youtube")) {
           	 	System.out.println("Going to YouTube");
           	 	comp = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe youtube.com";
            } else if(cmd.equalsIgnoreCase("end")) {
            	System.out.println("Ending Program");
            	break;
            }
			
			if(comp != null) {
				p = Runtime.getRuntime().exec(comp);
			}
		}
	}

}
