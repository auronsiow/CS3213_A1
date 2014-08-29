import java.util.*;

public class CircularGenerator implements IComponent {
	private static final String REGEX_SPLIT_WORDS = "\\s+";
	
	@Override
	public void process() {
		
		LinkedList<String> ll_StringList = DataSingleton.getData();
		int numLines = ll_StringList.size();
		LinkedList<String> ll_CircularStringList = new LinkedList<String>();
		
		for(int h=0; h < numLines; h++) {	
			String theString = ll_StringList.get(h);
			String words[] = theString.split(REGEX_SPLIT_WORDS);
			
			for(int i=0; i < words.length; i++) {
				int indexStart = i;
				String newSentence = "";
				for(int j=0; j < words.length; j++) {
					newSentence += words[indexStart] + " ";
					indexStart = (indexStart+1) % words.length;
				}
				ll_CircularStringList.add(newSentence);
			}
		}
		DataSingleton.setData(ll_CircularStringList);
	}

}
