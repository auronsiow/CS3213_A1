import java.util.LinkedList;


public class CircularGenerator implements IFilter {
	
	private static final String REGEX_SPLIT_WORDS = "\\s+";
	@Override
	public LinkedList<String> process(LinkedList<String> ll_Input) {
		int numLines = ll_Input.size();
		LinkedList<String> ll_StringList = new LinkedList<String>();
		
		for(int h=0; h < numLines; h++) {
			
			String theString = ll_Input.get(h);
	
			String words[] = theString.split(REGEX_SPLIT_WORDS);
			
			for(int i=0; i < words.length; i++) {
				int indexStart = i;
				String newSentence = "";
				for(int j=0; j < words.length; j++) {
					newSentence += words[indexStart] + " ";
					indexStart = (indexStart+1) % words.length;
				}
				ll_StringList.add(newSentence);
			}
		}
		
		return ll_StringList;
	}

}
