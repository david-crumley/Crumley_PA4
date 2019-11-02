import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
	
	private HashMap <String, Integer> wordCounter = new HashMap <String, Integer>();
	private ArrayList <String> uniqueWords = new ArrayList <String>();
		
	public void count (String dataFile) {
		try	{
			FileInputStream fileIn = new FileInputStream (dataFile);
			String buffer = new String();
			Scanner fileReader = new Scanner (fileIn);
			
			while (fileReader.hasNext())	{
				buffer = fileReader.next();
				
				if (uniqueWords.contains(buffer))	{
					wordCounter.put(buffer, wordCounter.get(buffer) + 1);
				}
				else {
					uniqueWords.add(buffer);
					wordCounter.put(buffer, 1);
				}
			}
			fileReader.close();
			fileIn.close();
		}
		catch (IOException IO)	{
			System.out.println("Found Exception: " + IO.getMessage());
		}
	}
	
	public void write (String outputFile)	{
		try	{
			FileOutputStream fileOut = new FileOutputStream(outputFile);
			PrintWriter write = new PrintWriter (fileOut);
			
			for (String currWord : uniqueWords)	{
				write.print(currWord + ": ");
				write.println(wordCounter.get(currWord));
			}
			write.close();
			fileOut.close();
		}
		catch (IOException IO)	{
			System.out.println("Found Exception: " + IO.getMessage());
		}
	}
	
}
