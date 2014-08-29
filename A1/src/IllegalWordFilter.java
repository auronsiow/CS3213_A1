
import java.util.*;

public class IllegalWordFilter implements IComponent {

	@Override
	public void process() {

		LinkedList<String> ll_StringList = DataSingleton.getData();
		LinkedList<String> ll_IllegalWordList = DataSingleton.getIllegalWords();
		
		LinkedList<String> ll_FilteredStringList = new LinkedList<String>();
		
		for(String strIterator : ll_StringList) {
			int indexOfFirstSpace = strIterator.indexOf(" ");
			String strFirstWord = strIterator.substring(0, indexOfFirstSpace);
			strFirstWord = strFirstWord.toLowerCase();
			if(!ll_IllegalWordList.contains(strFirstWord))
				ll_FilteredStringList.add(strIterator);
		}
		DataSingleton.setData(ll_FilteredStringList);
	}

}
