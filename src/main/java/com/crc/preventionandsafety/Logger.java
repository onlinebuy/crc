package com.crc.preventionandsafety;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.IOException;

public class Logger {

	private String path;
	private boolean appendToFile = true;
	
	public Logger(String filePath) {
		path = filePath;
	}
	
	public Logger(String filePath, boolean appendValue) {
		path = filePath;
		appendToFile = appendValue;
	}
	
	public void logToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, appendToFile);
		PrintWriter printLine = new PrintWriter(write);
		
		printLine.printf("%s" + "%n",  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss : ").format(Calendar.getInstance().getTime()) + textLine);
		
		printLine.close();
	}
}
