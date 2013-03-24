package org.stoners.beverage;

import java.io.PrintStream;
import java.util.List;

/**
 * 
 * @author clr
 *
 */
public class MenuPrinter {
	private PrintStream out;
	
	public MenuPrinter(PrintStream out) {
		this.out = out;
	}
	
	// List<? extends Object> says any subclass of Object up to and including Object is allowed
	// in place of T in List<T>
	public void printMenu(String prompt, List<? extends Object> choices) {
		for (int i = 0; i < choices.size(); i++) {
			out.printf("%d. %s\n", i + 1, choices.get(i).toString().replaceAll("_", " "));
		}
		out.print(prompt + ": ");
	}
	
	private int readInt() {
		String userInputStr;
		try {
			userInputStr = inputReader.readLine();
		} catch (IOException e) {
		userInputStr = "";
		}
		int userInput;
		try {
		userInput = Integer.parseInt(userInputStr);
		} catch(NumberFormatException e) {
		userInput = 0;
		}
		return userInput;
	}
	
	public Object handleSelection(List<? extends Object> choices) {
		handleSelection("Make a selection", choices);
	}
	
	public Object handleSelection(String prompt, List<? extends Object> choices) {
		printMenu(prompt, choices);
		int userInput = readInt();
		return choices.get(userInput-1);
	}
}
