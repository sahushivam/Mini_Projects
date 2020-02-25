package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import data.Car;
import data.Commands;
import data.Vehicle;
public class Main {
	
	public static void main(String args[]) {
	ProcessorImpl processor;
	Scanner sc = null;
	try {
		if(args.length > 0){ //by file
			String fileName = args[0];
			File f = new File(fileName);
			sc = new Scanner(f);
		}
		else
			sc = new Scanner(System.in); //by command line
		
		String line;
		processor = new ProcessorImpl();
		int lineNo = 0;
		while(sc.hasNextLine()){
			line = sc.nextLine();
			line.trim();
			if(processor.validate(line)) {
				try
				{
					processor.execute(line);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			else
			{
				System.out.println("Incorrect Command Found at line: " + lineNo + " ,Input: " + line);
			}
			lineNo++;
		}
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
	}
	finally
	{
		if (sc != null)
			sc.close();
	}
}
}
