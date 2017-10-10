package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		 
		Deck Deck1 = new Deck();
		for (int i = 0; i < 1000; i++) {
			Card c = Deck1.Draw();
		}
	}

	@Test
	public void TestDrawSuit() {
		 
		Deck iDeck = new Deck();
		Card c = iDeck.Draw(eSuit.DIAMONDS);
		assertTrue(c.geteSuit() == eSuit.DIAMONDS);
	}

	@Test
	public void TestDrawRank() {
		 
		Deck iDeck = new Deck();
		Card c = iDeck.Draw(eRank.ACE);
		assertTrue(c.geteRank() == eRank.ACE);
	}

	@Test
	public void TestDeckRankCount() {
		 
		Deck iDeck = new Deck();
		assertEquals(iDeck.countrank(pkgEnum.eRank.TWO), 4);
	}

	@Test
	public void TestDeckSuitCount() {
		 
		Deck iDeck = new Deck();
		assertEquals(iDeck.countSuit(pkgEnum.eSuit.CLUBS), 13);
	}

}
