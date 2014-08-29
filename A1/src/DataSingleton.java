import java.util.*;

public class DataSingleton {
	private static DataSingleton instance = null;
	
	private static LinkedList<String> ll_Data;
	private static LinkedList<String> ll_Illegal;
	
	protected DataSingleton() { ll_Data = new LinkedList<String>(); }
    
	public static DataSingleton getInstance() {
       if(instance == null)
    	   instance = new DataSingleton();
       return instance;
    }
	
	public static LinkedList<String> getData() { return ll_Data; }
	public static void setData(LinkedList<String> ll_InData) { ll_Data = ll_InData; }
	
	public static LinkedList<String> getIllegalWords() { return ll_Illegal; }
	public static void setIllegalWords(LinkedList<String> ll_InData) { ll_Illegal = ll_InData; }
}
