package edu.buffalo.cse116;

import java.util.HashMap;
import java.util.ArrayList;

public class Freecell extends Deck {
    //Check to see if duplicating cards. Make a proccess to stop adding an already existing card or repeated deletion of the same card.
    //If you delete a card, where does it go? If you add a card where does it go?
    //Idea to solve both problems: Make freecell_deck track what cards get added and removed!
    private HashMap<Integer, ArrayList<Card>> tableauMap;
    private HashMap<Integer, ArrayList<Card>> homecellMap;
    private HashMap<Integer, ArrayList<Card>> freecellMap;
    
    private ArrayList<Card> freecell_deck;   //The deck to fill
    private ArrayList<Card> deck;   //The normal 52 deck
   
    private boolean initial = true;
 
    /**
        Make the freecell constructor get take the private fields and set them equal

   */
    public Freecell(int tableauPiles, int homecellPiles, int freecellPiles) {
        super(tableauPiles, homecellPiles, freecellPiles);
    }

    public ArrayList<Card> getDeck() {
        return super.getDeck();
    }

    public int getTableauPiles() {
        return super.getTableauPiles();
    }

    public int getHomecellPiles() {
        return super.getHomecellPiles();
    }

    public int getFreecellPiles() {
        return super.getFreecellPiles();
    }

    //Change this so that the pilesList can be called from Main class.
    public void initialSetup() {
        while(initial) {
            deck = new ArrayList<Card>(getDeck()); //Result is that deck is empty 
            freecell_deck = new ArrayList<Card>(); //Result is that all of the cards in all piles are in this deck       

            this.tableauMap = new HashMap<Integer, ArrayList<Card>>();       
            this.freecellMap =  new HashMap<Integer, ArrayList<Card>>();
            this.homecellMap = new HashMap<Integer, ArrayList<Card>>();

            int trade = 0;
            int pile = 1;
            while(pile <= getTableauPiles() && pile <= getHomecellPiles() && pile <= getFreecellPiles()) {  
                for(int cardNum = 0; cardNum < 13; cardNum++) {
                    if(pile <=  (getTableauPiles() / 2) && cardNum <= 6) {                    
                        freecell_deck.add(deck.get(trade)); 
                        deck.remove(trade);
                    } else {
                        this.tableauMap.put(pile, freecell_deck);
                    }
                    if(cardNum > 6 && pile > (getTableauPiles() / 2)) { 
                        freecell_deck.add(deck.get(trade));  
                        deck.remove(trade);
                    } else {
                        this.tableauMap.put(pile, freecell_deck);
                    }
                }
                this.homecellMap.put(pile, deck);
                this.freecellMap.put(pile, deck);
                pile++;
            }       
        }
        initial = false;
    }

    //HashMap pile number, cards within each pile
    //pile number -> the pile # does not change
    //ArrayList cards
    
    public boolean removeCard(String whichPile, int whichNumber) { 
        int indexOfTopCard; 
        String stringToCompare = "tableau";
        boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
        if(compare == true) { 
            for(Integer key : this.tableauMap.keySet()) {
                if(whichNumber == key) {
                    deck = new ArrayList<Card>(this.tableauMap.get(key));					
                    if(deck.size() > 0) {
                        indexOfTopCard = deck.size() - 1;
                        deck.remove(indexOfTopCard);                                        //If put doesnt work use this
                        this.tableauMap.put(key, deck);                                     //this.tableauMap.replace(key,this.tableauMap.get(key), deck);
                        deck.clear();
                        return true;
                    }                      
                    else {
                        System.out.println("Can't remove anymore cards!");
                        return false;
                    }
                }
            }
        }
        
       stringToCompare = "homecell";
       compare = stringToCompare.equalsIgnoreCase(whichPile);
       if(compare == true) {
            System.out.println("Cards cannot be removed from a homecell Pile!");
            return false;
        }
       stringToCompare = "homecell";
       compare = stringToCompare.equalsIgnoreCase(whichPile);                
        if(compare = true) {   
            for(Integer key : this.freecellMap.keySet()) {
                if(whichNumber == key) {              
                    deck = new ArrayList<Card>(this.freecellMap.get(key));                 
                    if(deck.size() > 0) {
                        indexOfTopCard = deck.size() - 1;    
                        deck.remove(indexOfTopCard);                                        
                        this.freecellMap.put(key, deck);                                     
                        deck.clear();
                        return true;
                    }                                        
                    else {
                        System.out.println("Can't remove anymore cards!");
                        return false;
                   }
                }                                        
            }   
        }
        return false;
    }
    

    public boolean addCard(String whichPile, int whichNumber) {
        //A card can be added to a tableau pile when its value is one less than the tableau's top card AND its suit is the opposite of the top card's suit.
        //The added card becomes the tableau's new top card. ANY card CAN be added to an empty tableau.
        String stringToCompare = "tableau";
        boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
        if(compare == true) {
        	return compare;
        }
		return compare;
    	
    }
}

//
