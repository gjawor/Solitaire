package cs3500.freecell.model;


import java.util.Collections;
import java.util.List;


/**
 * Class to represent a deck. Decks have a list of cards and an int for the topcard index.
 */
public class Deck {
  private List<Card> deck;
  private int topcard;

  /**
   * Empty deck constructor.
   */
  public Deck() {
    // intentionally empty
  }


  /**
   * constructor for deck -- every deck has a list of cards and int for topcard index.
   *
   * @param deck must be list of cards
   */
  public Deck(List<Card> deck) {
    this.deck = deck;
    this.topcard = (deck.size() - 1);
  }

  /**
   * method to retrieve the list of cards from the deck.
   *
   * @return List<Card></Card> list of cards making up deck
   */
  public List<Card> getDeck() {
    return deck;
  }

  /**
   * method to find size of deck (used to check validity).
   *
   * @return int size of deck
   */
  public int deckSize() {
    int dsize = deck.size();
    return dsize;
  }

  /**
   * shuffles the list of cards and puts them in new order.
   *
   * @return List<Card></Card> same cards in new order
   */
  public List<Card> shuffle() {
    Collections.shuffle(deck);
    return deck;
  }

  /**
   * removes the last card from the deck and returns it.
   *
   * @return card from end of deck
   * @throws IllegalArgumentException if no cards left in deck
   */
  public Card removeLastCard() {
    if (deck.size() == 0) {
      throw new IllegalArgumentException("no cards left to remove");
    }

    Card lastcard = deck.remove(topcard);
    topcard--;
    return lastcard;

  }


}
