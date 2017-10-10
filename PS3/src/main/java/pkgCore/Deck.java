package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {

		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	 
	public Card Draw() throws DeckException {
		if (this.cardsInDeck.size() == 0) {
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);
	}

	 
	public Card Draw(eSuit eSuit) {
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	 
	public Card Draw(eRank eRank) {
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	 
	public int countSuit(eSuit eSuit) {
		ArrayList<Card> eSuitLeft = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));

		return eSuitLeft.size();
	}

	 
	public int countRank(eRank eRank) {
		ArrayList<Card> eRankLeft = cardsInDeck.stream().filter(c -> c.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));

		return eRankLeft.size();
	}

	 
	public int FindCard(Card c) {
		for (Card i : cardsInDeck) {
			if (i == c)
				return 1;
		}
		return 0;
	}
}
