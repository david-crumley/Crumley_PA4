import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
	
	HashSet<String> uniqueWords = new HashSet <String>();	
	
	public void remove (String dataFile)	{
		try	{	
			FileInputStream fileIn = new FileInputStream (dataFile);
			String buffer   = new String();
			Scanner fileReader  = new Scanner (fileIn);
				
			while (fileReader.hasNext())	{
			
				buffer = fileReader.next();
			
				if (uniqueWords.contains(buffer))	{
					continue;
				}
				else	{
					uniqueWords.add(buffer);
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
			FileWriter fileOut = new FileWriter(outputFile);
			
			for (String currWord : uniqueWords)	{
				fileOut.write(currWord);
				fileOut.write('\n');
			}
			
			fileOut.close();
		}
		catch (IOException IO)	{
			System.out.println("Found Exception: " + IO.getMessage());
		}
	}

}


