//------------------------------------------------------------------------------------------
// Name: Siow Wei Qi, Auron
// Matric No: A0097801B
// 
// Description: This is the entry point for Key Word In Context (KWIC) program.
//
//------------------------------------------------------------------------------------------

import java.util.*;
import java.io.*;

public class KWICProgram {	

	public static final String WELCOME_TEXT_FILE_PATH = "other_resources/help.txt";
	public static final String REPLAY_KEY = "y";
	public static final String PROMPT_REPLAY_KEY = "To replay, press \"";
	public static final String PROMPT_TERMINATE_KEY = "\". Otherwise, press any key to exit.";
	public static final String PROMPT_TERMINATION = "---Thank you for using KWIC---";
	public static final String TEST_CASE_PATH = "other_resources/TestCase3_LargeUnRes.txt"; 

	public static void main(String arg[]) {
		displayWelcomeText();
		
		while (true) {
			
			KWICPipeline pipeline = new KWICPipeline();
			DataSource srcComponent = new DataSource();
			CircularGenerator cirComponent = new CircularGenerator();
			IllegalWordFilter illComponent = new IllegalWordFilter();
			AlphabetSort sortComponent = new AlphabetSort();
			OutputSink sinkComponent = new OutputSink();
			
			pipeline.addLink(srcComponent);
			pipeline.addLink(cirComponent);
			pipeline.addLink(illComponent);
			pipeline.addLink(sortComponent);
			pipeline.addLink(sinkComponent);
			
			pipeline.process();
			
			// Get user's feedback to exit or replay
			if (!playAgain())
				break;
		}
		
		System.out.println(PROMPT_TERMINATION);
	}
	
	public static void displayWelcomeText() {
		try {
			BufferedReader reader =  new BufferedReader(new FileReader(WELCOME_TEXT_FILE_PATH));
			String inputText = null;

			// Display all the text in the input file
			while ( (inputText = reader.readLine() ) != null)
				System.out.println(inputText);
			reader.close();
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
	}

	public static boolean playAgain() {

		Scanner sc = new Scanner(System.in);
		System.out.println(PROMPT_REPLAY_KEY + REPLAY_KEY + PROMPT_TERMINATE_KEY);
		try {
			if(sc.nextLine().contains(REPLAY_KEY))
				return true;
			else
				return false;
		}
		catch (Exception err) {
			return false;
		}
	}
	
	public static void runTestCase() {
		try {
			System.setIn(new FileInputStream(TEST_CASE_PATH));
		}
		catch (Exception err) {
			err.printStackTrace();
		}
	}

}
