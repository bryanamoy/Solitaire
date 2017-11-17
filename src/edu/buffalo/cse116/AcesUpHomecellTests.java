package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class AcesUpHomecellTests {

	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();
	
	AcesUp auTest = new AcesUp(); //to be changed
	
	@Test
	public void testEmptyHCPile() {
		auTest.initialSetup();
		assertEquals("Homecell pile should initiate with zero cards", 0, auTest.getHomecellPiles().get(0));
	}
	
	@Test
	public void testAddSpecificCardLegalOrIllegalHCPile() {
		auTest.initialSetup();
		auTest.getHomecellPiles_List();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.SPADES, Rank.EIGHT);
		boolean legal = auTest.addToHomecell(first, 0);
		boolean illegal = auTest.addToHomecell(second, 0);
		int sizeofPile = auTest.getHomecellPileSize(0);
		assertTrue("legal", legal);
		assertFalse("illegal", illegal);
	}
	
	@Test
	public void testRemovingTopCardAlwaysIllegalHCPile() {
		
		auTest.initialSetup();

		assertFalse("Should always be false", auTest.removeFromHomecell());
	}
	
	@Test
	public void testAddingCardIncreasesSizeAndTopCardHCPile() {
		
		auTest.initialSetup();

		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.DIAMONDS, Rank.TWO);
		auTest.addToHomecell(first, 0);
		auTest.addToHomecell(second, 0);
		assertEquals("new top card",second, auTest.getHomecellPiles_List().get(0).get(0));
		assertEquals("size of pile", 2, auTest.getHomecellPiles_List().get(0).size());

		
	}
	
}
