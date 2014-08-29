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

	public static final String REPLAY_KEY = "y";
	public static final String WELCOME_TEXT_FILE_PATH = "other_resources/help.txt";
	public static final String PROMPT_TERMINATION = "---Thank you for using KWIC---";
	public static final String PROMPT_NUM_LINES = "Enter number of lines: ";
	public static final String PROMPT_ILLEGAL_WORDS = "Enter illegal words: ";
	public static final String PROMPT_REPLAY_KEY = "To replay, press \"";
	public static final String PROMPT_TERMINATE_KEY = "\". Otherwise, press any key to exit.";
	public static final String PROMPT_OUTPUT = "Output: ";

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
	
		displayWelcomeText();
		
		boolean isPlaying = true;
		
		while (isPlaying) {
			
			LinkedList<String> ll_LinesToCheck = new LinkedList<String>();
			LinkedList<String> ll_IllegalKeywordList = new LinkedList<String>();
			
			getUserInput(sc, ll_LinesToCheck, ll_IllegalKeywordList);
			
			// Generate Circular lines
			
			// Sort Circular lines alphabetically
			
			// Remove illegal keywords found
			
			// Display output
			printKWICOutput(ll_LinesToCheck);

			// Get user's feedback to exit or replay
			isPlaying = getUserReplay(sc);
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
	
	public static boolean getUserReplay(Scanner sc ) {
		System.out.println(PROMPT_REPLAY_KEY + REPLAY_KEY + PROMPT_TERMINATE_KEY);
		if(sc.nextLine().contains(REPLAY_KEY))
			return true;
		else
			return false;
	}
	
	public static void getUserInput(Scanner sc, LinkedList<String> ll_LinesToCheck, LinkedList<String> ll_IllegalKeywordList) {
		getNumberOfLines(sc, ll_LinesToCheck);
		getIllegalWords(sc, ll_IllegalKeywordList);
	}
	
	public static void getNumberOfLines(Scanner sc, LinkedList<String> ll_LinesToCheck) {
		// Get # of lines of text
		System.out.print(PROMPT_NUM_LINES);
		int numLines = sc.nextInt();

		// Clear the buffer
		sc.nextLine();

		// Get each individual input of text
		for(int i=0; i < numLines; i++) {
			System.out.print("Enter line " + (i+1) + " of " + numLines + ": ");
			String input = sc.nextLine();
			ll_LinesToCheck.add(input);
		}
	}
	
	public static void getIllegalWords(Scanner sc, LinkedList<String> ll_IllegalKeywordList) {
		// Get the string of illegal words
		System.out.print(PROMPT_ILLEGAL_WORDS);
		String str_inputIllegal = sc.nextLine();

		StringTokenizer st = new StringTokenizer(str_inputIllegal);
		while(st.hasMoreTokens())
			ll_IllegalKeywordList.add(st.nextToken().toLowerCase());
	}
	
	public static void printKWICOutput(LinkedList<String> ll) {
		System.out.println(PROMPT_OUTPUT);
		for(String s : ll) {
			String firstChar = s.substring(0,1);
			firstChar = firstChar.toUpperCase();
			String outStr = firstChar + s.substring(1);
			System.out.println(outStr);
		}
		System.out.println();
	}
}
