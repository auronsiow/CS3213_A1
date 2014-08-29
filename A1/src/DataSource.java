import java.util.*;

public class DataSource implements IComponent {
	private static final String PROMPT_NUM_LINES = "Enter number of lines: ";
	private static final String PROMPT_ILLEGAL_WORDS = "Enter illegal words: ";
	
	@Override
	public void process() {
		Scanner sc = new Scanner(System.in);
		
		LinkedList<String> ll_LinesToCheck = new LinkedList<String>();
		LinkedList<String> ll_IllegalKeywordList = new LinkedList<String>();
		
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
		
		// Get the string of illegal words
		System.out.print(PROMPT_ILLEGAL_WORDS);
		String str_inputIllegal = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str_inputIllegal);

		while(st.hasMoreTokens())
			ll_IllegalKeywordList.add(st.nextToken().toLowerCase());
		
		DataSingleton.setData(ll_LinesToCheck);
		DataSingleton.setIllegalWords(ll_IllegalKeywordList);
	}

}
