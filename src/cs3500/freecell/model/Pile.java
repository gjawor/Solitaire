package cs3500.freecell.model;

import java.util.ArrayList;

/**
 * Class to represent a pile of cards.
 */
public class Pile {
  protected PileType piletype;
  protected ArrayList<Card> cards;
  protected int topcard;

  /**
   * Pile constructor -- piles have a type, list of cards, and int for topcard index.
   * @param piletype enum -- cascade, open, or foundation
   * @param cards List<Card></Card>
   * @param topcard int of last card in pile index
   */
  public Pile(PileType piletype, ArrayList<Card> cards, int topcard) {
    this.piletype = piletype;
    this.cards = cards;
    this.topcard = (cards.size() - 1);

  }

  /**
   * Empty constructor for piletype so it can be set by subclasses.
   * @param piletype enum type -- foundation, cascade, or open
   */
  public Pile(PileType piletype) {
    /* type is set in specific subclasses */
    this.piletype = piletype;
    this.cards = new ArrayList<>();
  }

  /**
   * method to find the size of a pile of cards.
   * @return int of card pile size
   */
  public int getSize() {
    return cards.size();
  }


}
