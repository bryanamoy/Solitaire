package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;

public class BakersDozen extends Deck{
	HashMap Tableau;
	HashMap Homecell;
	
	
	public HashMap getTableau() {
		return Tableau;
	}

	public void setTableau(HashMap tableau) {
		Tableau = tableau;
	}

	public HashMap getHomecell() {
		return Homecell;
	}

	public void setHomecell(HashMap homecell) {
		Homecell = homecell;
	}

	public void getDeck(){
		// super.getDeck();
		
	}
	
	public void initialSetup(){
		
	}
	
	public void addToTableau(){
		
	}
	
	public void removeFromTableau(){
		
	}
	
	public void addToHomecell(){
		
	}
	
	public int getTableauSize(){
		
		return 5;
	}
	
	public boolean getLegal(){
		return false;
	}
	
	public boolean removalIllegal(){
		return false;
	}
	
	
	
}