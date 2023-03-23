package cs3500.freecell.model;

import java.util.ArrayList;

/**
 * Subclass to represent an open pile.
 */
public class OpenPile extends Pile {

  /**
   * An open pile is a type of pile in freecell.
   * @param cards list of cards, open pile can only hold one card at a time
   * @param topcard value of top card
   */
  public OpenPile(ArrayList<Card> cards, int topcard) {

    super(PileType.OPEN, cards, topcard);

  }


  public OpenPile() {
    super(PileType.OPEN);
  }

  /**
   * Adds a card to the pile if pile is empty, can only hold one card at a time.
   * @param card to be added to pile
   */
  public void addCard(Card card) throws RuntimeException {
    int x = cards.size();
    if (x == 0) {
      this.cards.add(card);
    } else {
      throw new RuntimeException("Cannot have more than one card in pile");

    }
  }

  /**
   * Removes a card from pile unless pile is empty.
   * @return Card card that was removed
   * @throws RuntimeException if pile is empty so nothing to remove
   */
  public Card removeCard() throws RuntimeException {
    Card c;
    int x = cards.size();
    if (x == 1) {
      c = this.cards.remove(0);
    } else {
      throw new RuntimeException("Empty pile cannot remove");
    }
    return c;
  }
}

