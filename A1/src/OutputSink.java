import java.util.*;

public class OutputSink implements IComponent {

	private static final String PROMPT_OUTPUT = "Output: ";

	@Override
	public void process() {
		System.out.println(PROMPT_OUTPUT);
		LinkedList<String> ll_Data = DataSingleton.getData();
		for(String s : ll_Data) {
			String firstChar = s.substring(0,1);
			firstChar = firstChar.toUpperCase();
			String outStr = firstChar + s.substring(1);
			System.out.println(outStr);
		}
		System.out.println();
	}

}
