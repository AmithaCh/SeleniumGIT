package selenium_littleadvanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParameterizedNotepad {
		
	public void NotepadReading() throws IOException
		{
			File file=new File("E:\\NotepadReading.txt");
			FileReader fr=new FileReader(file);
			int content=fr.read();
			while(content!=-1)	//here -1 is end of file
			{
				System.out.print((char)content);
				//the output is in ascii values so thats why we are converting it 
				//into char and using print instead of println to get output in the
				//form of string.
				
				content=fr.read();
				
			}		
		}
	public void BufferedReaderClass() throws IOException
	{
		File file=new File("E:\\NotepadReading.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		//using buffered class we can read the data as a string.
		String output=br.readLine();
		while(output!=null)//null is called end of file.
		{
			System.out.println(output);
			output=br.readLine();
		}	
	}
	public void WritingNotepad() throws IOException
	{
		File file=new File("E:\\NotepadWriting.txt");
		FileWriter fw=new FileWriter(file,true);//true helps us in appending to the existing string
		fw.write("My first writing into notepad through selenium-java");
		//fw.flush();
		fw.close();
		System.out.println("writing done");
		
	}
	public void BufferedWritingClass() throws IOException
	{
		File file=new File("E:\\NotepadWriting.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write("writing into notepad using Buffered writing class");
		bw.flush();
		bw.close();
		System.out.println("Done");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ParameterizedNotepad pe=new ParameterizedNotepad();
		//pe.NotepadReading();
		//pe.BufferedReaderClass();
		//pe.WritingNotepad();
		pe.BufferedWritingClass();
		
	}

}
