import java.util.*;

public class AlphabetSort implements IComponent {

	@Override
	public void process() {
		LinkedList<String> ll_StringList = DataSingleton.getData();
		
		// Sort strings with case insensitivity 
		Collections.sort(ll_StringList, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareToIgnoreCase(s2);
	        }
	    });
		
		DataSingleton.setData(ll_StringList);
	}
 
}
