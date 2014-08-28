import java.util.LinkedList;


public class IllegalWordFilter implements IFilter {

	private LinkedList<String> ll_IllegalWordList;
	
	public IllegalWordFilter(LinkedList<String> ll_InputIllegal) {
		ll_IllegalWordList = ll_InputIllegal;
	}
	
	@Override
	public LinkedList<String> process(LinkedList<String> ll_Input) {
		LinkedList<String> ll_StringList = new LinkedList<String>();
		
		for(int i=0; i < ll_Input.size(); i++) {
			String strIterator = ll_Input.get(i);
			
			int indexOfFirstSpace = strIterator.indexOf(" ");
			String strFirstWord = strIterator.substring(0, indexOfFirstSpace);
			strFirstWord = strFirstWord.toLowerCase();
			
			if(!ll_IllegalWordList.contains(strFirstWord))
				ll_StringList.add(strIterator);
		}
		return ll_StringList;
	}

}
