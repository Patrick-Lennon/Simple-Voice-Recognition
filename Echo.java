/**
 * Program is to implement the SPhinx4 API by using it's jar files.
 * 
 * @author Patrick Lennon
 */

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class Echo {
	
	public static void main(String[] args) throws IOException{
		
		//The configuration is what meshes together the different models
		Configuration config = new Configuration();
		//the dictionary with all the words and pronounciations
		String dicPath = "file:C:\\Users\\me\\eclipse-workspace\\VRPro\\src\\prodic.dic";
		//language model are how words are treated numerically
		String lmPath = "file:C:\\Users\\me\\eclipse-workspace\\VRPro\\src\\langmodel.lm";
		//Acoustic model is how it recognizes you're using a language
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath(dicPath);
		config.setLanguageModelPath(lmPath);
		
		LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
		rec.startRecognition(true);
		
		SpeechResult result;
		
		//if I say anything, check to see if it matching anything in the dictionary
		//In "taskkill /F /IM", taskkill is the command, 'F' means force quit, and 'IM' means you'll provide the .exe
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
