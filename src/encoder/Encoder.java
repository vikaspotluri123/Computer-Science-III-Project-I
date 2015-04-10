package encoder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Encoder 
{
    
	private String _fileName;
	private FileWriter _fileWriter;
	private FileReader _fileReader;
	
	public Encoder (String filename)
	{
		//STEPS
		//1. Create a FileWriter (which creates a file in the process)
		//2. Create a FileReader (which can read from a file)
		try 
		{
			_fileWriter = new FileWriter("userMessages/" + filename);
		} 
		catch (IOException e) 
		{
			// TODO Display Catch Exception
		}
		
		try 
		{
			_fileReader = new FileReader("userMessages/" + filename);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Display Catch Exception
		}
	}
	
	private String encode (String plaintext)
	{
		String encoded = "";
		//Encodes plain text into obfuscated text
		
		for (char c : plaintext.toCharArray())
		{
			int p = (int) c;
			p = p + 13;
			char d = (char)p;
			encoded += String.valueOf(d);
		}
		return encoded;
	}
	
	private String decode (String encodedText)
	{
		String decoded = "";
		//Encodes plain text into obfuscated text
		
		for (char c : encodedText.toCharArray())
		{
			int p = (int) c;
			p = p - 13;
			char d = (char)p;
			decoded += String.valueOf(d);
		}
		return decoded;
	}
	
	public void write(String plaintext)
	{
		List<String> prev = this.read();
		String encoded = "";
		for(String s : prev)
		{
			encoded += encode(s)  + "\n"; 
		}
		encoded += this.encode(plaintext);
		try 
		{
			_fileWriter.write(encoded);
			_fileWriter.close();
		} 
		catch (IOException e) 
		{
			// TODO Display Catch Exception
		}
	}
	
	public List<String> read()
	{
		ArrayList<Character> lulz = new ArrayList<>();
		char txt = 'a';
		try {
			int read = _fileReader.read();
			while(read != -1)
			{
				txt = (char) read;
				read = _fileReader.read();
				lulz.add(txt);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}