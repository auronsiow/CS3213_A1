//------------------------------------------------------------------------------------------
// Name: Siow Wei Qi, Auron
// Matric No: A0097801B
// 
// Description: Sort a list of string alphabetically
//
//------------------------------------------------------------------------------------------
import java.util.*;

public class AlphabetSort implements IFilter {

	@Override
	public LinkedList<String> process(LinkedList<String> ll_Input) {
		LinkedList<String> ll_StringList = ll_Input;
		Collections.sort(ll_StringList);
		return ll_StringList;
	}

}
