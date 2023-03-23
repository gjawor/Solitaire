package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclass to represent a cascade pile.
 */
public class CascadePile extends Pile {

  public CascadePile(ArrayList<Card> cards, int topcard) {
    super(PileType.CASCADE, cards, topcard);
    this.topcard = (cards.size() - 1);
  }

  public CascadePile() {
    super(PileType.CASCADE);
  }


  /**
   * Adds a card to the end of a card pile if its color is different from that of the
   * currently last card, and its value is exactly one less than that of the currently last card
   * otherwise throws exception.
   *
   * @param card to be added to pile
   */
  public void addCard(Card card) throws RuntimeException {
    Suit s = card.getSuit();
    int size = cards.size();

    if (size == 0) {
      cards.add(card);
    } else if (size > 0) {
      Card lastcard = cards.get(topcard);
      Suit pilecard = lastcard.getSuit();
      int v = card.getValue();
      int vcard = lastcard.getValue();
      if ((s == Suit.SPADES || s == Suit.CLUBS)
              && (pilecard == Suit.DIAMONDS || pilecard == Suit.HEARTS)
              && (v == vcard - 1)) {
        this.cards.add(card);
        topcard++;
      } else if ((s == Suit.HEARTS || s == Suit.DIAMONDS)
              && (pilecard == Suit.CLUBS || pilecard == Suit.SPADES)
              && (v == vcard - 1)) {
        this.cards.add(card);
        topcard++;
      }
    } else {
      throw new RuntimeException("Card does not meet criteria, cannot add to pile");
    }
  }

  /**
   * Adds a build of cards to the destination pile.
   *
   * @param build list of cards that make up a valid build
   */
  public void addBuild(ArrayList<Card> build) {
    Card buildCard = build.get(0);
    Suit buildSuit = buildCard.getSuit();
    int valueBuild = buildCard.getValue();
    int topcard = this.cards.size() - 1;
    Card topcardCard = this.cards.get(topcard);
    Suit topcardSuit = topcardCard.getSuit();
    int valueTopcard = topcardCard.getValue();

    if (cards.size() == 0) {
      this.cards.addAll(build);
    } else {
      if ((buildSuit == Suit.SPADES || buildSuit == Suit.CLUBS)
              && (topcardSuit == Suit.DIAMONDS || topcardSuit == Suit.HEARTS)
              && (valueBuild == valueTopcard - 1)) {
        this.cards.addAll(build);
        topcard = topcard + build.size();
      } else if ((buildSuit == Suit.HEARTS || buildSuit == Suit.DIAMONDS)
              && (topcardSuit == Suit.CLUBS || topcardSuit == Suit.SPADES)
              && (valueBuild == valueTopcard - 1)) {
        this.cards.addAll(build);
        topcard = topcard + build.size();
      } else {
        throw new RuntimeException("Card does not meet criteria, cannot add to pile");
      }
    }
  }


  /**
   * Method to deal cards round robin style to cascade piles.
   *
   * @param card no specifications, just is taken in and added
   */
  public void dealCard(Card card) {
    if (cards.size() == 0) {
      cards.add(card);
    } else {
      cards.add(card);
      topcard++;
    }

  }


  /**
   * Removes last card (topcard) from pile and returns it.
   *
   * @return card from pile
   */
  public Card removeCard() {
    if (cards.size() == 0) {
      throw new RuntimeException("No card to remove");
    }
    Card lastcard = cards.remove(topcard);
    topcard--;
    return lastcard;
  }

  /**
   * Removes the build from the cascade pile they came from.
   * @param start of build
   * @return build in own list
   */
  public ArrayList<Card> removeBuild(int start) {
    ArrayList<Card> build = new ArrayList<Card>();
    List<Card> buildList = this.cards.subList(start, cards.size());
    for (Card card : buildList) {
      build.add(card);
    }
    this.cards.subList(start, cards.size()).clear();
    return build;

  }


}
