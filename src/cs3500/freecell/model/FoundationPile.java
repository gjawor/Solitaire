package cs3500.freecell.model;

import java.util.ArrayList;


/**
 * Subclass to represent a foundation pile.
 */
public class FoundationPile extends Pile {


  public FoundationPile(ArrayList<Card> cards, int topcard) {
    super(PileType.FOUNDATION, cards, topcard);
    this.topcard = (cards.size() - 1);
  }

  public FoundationPile() {
    super(PileType.FOUNDATION);
  }


  /**
   * Adds a card to the end of a card pile  if its suit matches that of the pile,
   * and its value is one more than that of the card currently on top of the pile.
   * Can add ace if pile is empty.
   *
   * @param card to be added to pile
   */
  public void addCard(Card card) throws RuntimeException {
    Suit s = card.getSuit();
    int size = cards.size();
    int v = card.getValue();
    if ((size == 0) && (v == 1)) {
      this.cards.add(card);
    } else {
      Card lastcard = cards.get(topcard);
      Suit pilecard = lastcard.getSuit();

      int vcard = lastcard.getValue();


      if ((s == pilecard) && (v == vcard + 1)) {
        this.cards.add(card);
        topcard++;
      } else {
        throw new IllegalArgumentException("Card does not meet criteria, cannot add here");
      }

    }
  }
}


