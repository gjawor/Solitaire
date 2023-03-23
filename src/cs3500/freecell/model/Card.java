package cs3500.freecell.model;

/**
 * Class to represent a card. Ace is represented by 1, 2-10 stay the same, J is 11, Q is 12,
 * K is 13.
 */
public class Card {
  private Suit suit;
  private int value;

  /**
   * Card constructor -- every card has a suit and value assigned.
   * @param suit enum
   * @param value int
   */
  public Card(Suit suit, int value) {
    this.suit = suit;
    this.value = value;
  }

  /**
   * getSuit returns the card's suit. Suit can either be clubs, spades, diamonds, or hearts.
   *
   * @return suit enum
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * getValue returns the card's value. value can be 1-13.
   *
   * @return int value
   */
  public int getValue() {
    return value;
  }


  /**
   * toString returns the card suit and value as a string to be used for model view.
   *
   * @return string card
   */
  public String toString() {
    if (suit == Suit.DIAMONDS) {
      return String.valueOf(value) +
              "♦";
    } else if (suit == Suit.CLUBS) {
      return String.valueOf(value)
              + "♣";
    } else if (suit == Suit.SPADES) {
      return String.valueOf(value)
              + "♠";
    }
    return String.valueOf(value)
            + "♥";
  }
}



