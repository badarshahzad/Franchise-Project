package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class File {
	
	public static void main(String args[]){
		
		PrintWriter outputstream = null;
		try{
			outputstream = new PrintWriter(new FileOutputStream("out.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("Error in opening the out.txt!");
			System.exit(0);
		}
		System.out.println("Enter three lines:");
		String line = null;
		Scanner keyboard = new Scanner(System.in);
		
		for(int a=0;a<3;a++){
			line= keyboard.nextLine();
			outputstream.println(a+" "+line);
		}
		outputstream.close();
		System.out.println("Those lines are written in out.txt!");
		
	}

}
