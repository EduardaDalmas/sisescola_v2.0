package br.com.ienh.sisescola.app;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import br.com.ienh.sisescola.ui.UserInterface;

public class App {

	public static void main(String[] args) {
		
		Logger.getRootLogger().setLevel(Level.OFF);
		
		UserInterface.run();
		
	}

}
