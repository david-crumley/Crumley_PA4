public class Application {
	public static void main (String[] arg)	{
		DuplicateRemover test = new DuplicateRemover();
		
		test.remove ("problem1.txt");
		test.write("unique_words.txt");
		
	}
}
