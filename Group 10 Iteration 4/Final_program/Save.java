import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.*;


public class Save {

	
	static ArrayList<String> save = new ArrayList<>();
	private String path;
	private boolean appendToFile = false;
	
	
	public Save(String filePath, ArrayList<JButton> buttonList){
		path = filePath;	 
	}
	public Save(String filePath, boolean appendValue, ArrayList<JButton> buttonList){
		path = filePath;
		appendToFile = appendValue;
	}
	
	
	
	public void writeToFile( ArrayList<JButton> buttonList ) throws IOException {
		
		FileWriter write = new FileWriter(path, appendToFile);
		PrintWriter printLine = new PrintWriter(write);
		for(int i = 0; i < buttonList.size(); i++) {
			save.set(i, (buttonList.get(i).getIcon().toString()));    
			printLine.printf("%s"+"%n", buttonList.get(i).getIcon().toString());
		}
		printLine.close();
		
		
		
		
	}
	
	
	

	public String getText(int i) {
		return(save.get(i));
	}
	
	
	
	
	
}
