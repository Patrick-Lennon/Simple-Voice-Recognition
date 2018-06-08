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
			String stuff = null;
			Process p;
			if(cmd.equalsIgnoreCase("open file manager")) {
                System.out.println("File Manager Opened!");
            } else if (cmd.equalsIgnoreCase("close file manager")) {
                System.out.println("File Manager Closed!");
            } else if (cmd.equalsIgnoreCase("open browser")) {
                System.out.println("Browser Opened!");
            } else if (cmd.equalsIgnoreCase("close browser")) {
                System.out.println("Browser Closed!");
            }
		}
	}

}
