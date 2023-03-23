package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class to represent a freecell model. the model can either be simple or multi-move and
 * the only difference is that mutlimove allows the client to move mutliple cards at once.
 */
abstract class CardFreecellModel implements FreecellModel<Card> {
  ArrayList<CascadePile> cascade;
  ArrayList<FoundationPile> foundation;
  ArrayList<OpenPile> open;
  boolean gameStarted;
  Deck cardDeck = new Deck();


  CardFreecellModel() {
    this.cascade = new ArrayList<CascadePile>();
    this.foundation = new ArrayList<FoundationPile>();
    this.open = new ArrayList<OpenPile>();
    this.gameStarted = false;

  }


  /**
   * gets a deck -- list of cards.
   *
   * @return List<Card> </Card> deck
   */
  public List<Card> getDeck() {
    return this.cardDeck.getDeck();
  }

  /**
   * Starts a game of freecell solitaire by checking if the deck is valid, and creates respective
   * piles based on input.
   *
   * @param deck            the deck to be dealt
   * @param numCascadePiles number of cascade piles
   * @param numOpenPiles    number of open piles
   * @param shuffle         if true, shuffle the deck else deal the deck as-is
   * @throws IllegalArgumentException if deck is invalid or invalid number
   *                                  of cascade or open piles
   */
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    // validates deck
    validateDeck(deck);
    if (!validateDeck(deck)) {
      throw new IllegalArgumentException("invalid deck");
    }
    this.cardDeck = new Deck(deck);
    // shuffles if true
    if (shuffle) {
      cardDeck.shuffle();
    }


    // pile specification
    if (numCascadePiles <= 3 || numCascadePiles >= 9) {
      throw new IllegalArgumentException("invalid number of cascade piles");
    } else if (numOpenPiles <= 0 || numOpenPiles >= 5) {
      throw new IllegalArgumentException("invalid number of open piles");
    }

    // creates desired number of cascade piles
    for (int c = 0; c < numCascadePiles; c++) {
      cascade.add(new CascadePile());
    }

    // creates desired number of open piles
    for (int o = 0; o < numOpenPiles; o++) {
      open.add(new OpenPile());
    }
    // creates foundation piles
    for (int f = 0; f < 4; f++) {
      foundation.add(new FoundationPile());
    }
    // deals cards
    this.deal();


  }

  /**
   * moves a card from its initial pile to a new one if it follows freecell rules.
   *
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source
   *                       pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   */
  public abstract void move(PileType source, int pileNumber, int cardIndex,
                            PileType destination, int destPileNumber);

  /**
   * method checking to see if foundation piles are full indicating the game is over.
   *
   * @return boolean true if game over, false otherwise
   */
  public boolean isGameOver() {
    for (int g = 0; g < 4; g++) {
      if (getNumCardsInFoundationPile(g) < 13) {
        return false;
      }
    }
    return true;

  }

  /**
   * gets the number of cards in a given foundation pile.
   *
   * @param index the index of the foundation pile, starting at 0
   * @return int number of cards
   */
  public int getNumCardsInFoundationPile(int index) {
    if (index < 0 || open.isEmpty() || !gameStarted) {
      return -1;
    } else {
      FoundationPile fcards = foundation.get(index);
      int fcardsize = fcards.cards.size();
      return fcardsize;
    }
  }

  /**
   * gets the number of cascade piles.
   *
   * @return int number of piles
   */
  public int getNumCascadePiles() {
    int cpiles = cascade.size();
    return cpiles;
  }

  /**
   * get the number of cards in a cascade pile.
   *
   * @param index the index of cascade pile, starts at 0
   * @return int number of cards
   */
  public int getNumCardsInCascadePile(int index) {
    if (index < 0 || open.isEmpty() || !gameStarted) {
      return -1;
    } else {
      CascadePile ccards = cascade.get(index);
      int ccardsize = ccards.cards.size();
      return ccardsize;
    }
  }


  /**
   * get the number of cards in an open pile.
   *
   * @param index the index of the open pile, starting at 0
   * @return int number of cards
   */
  public int getNumCardsInOpenPile(int index) {
    if (index < 0 || open.isEmpty() || !gameStarted) {
      return -1;

    } else {
      OpenPile ocards = open.get(index);
      int ocardsize = ocards.cards.size();
      return ocardsize;
    }


  }

  /**
   * provides the number of open piles.
   *
   * @return int number of piles
   */
  public int getNumOpenPiles() {
    int opiles = open.size();
    return opiles;
  }

  /**
   * Get the card at the provided index in the provided foundation pile.
   *
   * @param pileIndex the index of the foundation pile, starting at 0
   * @param cardIndex the index of the card in the above foundation pile, starting at 0
   * @return card topcard from founadtion pile
   */
  public Card getFoundationCardAt(int pileIndex, int cardIndex) {
    FoundationPile fpile = foundation.get(pileIndex);
    Card fcard = fpile.cards.get(cardIndex);
    return fcard;
  }

  /**
   * Get the card at the provided index in the provided cascade pile.
   *
   * @param pileIndex the index of the cascade pile, starting at 0
   * @param cardIndex the index of the card in the above cascade pile, starting at 0
   * @return card topcard from cascade pile
   */
  public Card getCascadeCardAt(int pileIndex, int cardIndex) {
    CascadePile cpile = cascade.get(pileIndex);
    Card ccard = cpile.cards.get(cardIndex);
    return ccard;
  }

  /**
   * Get the card in the open pile based on pile index.
   *
   * @param pileIndex the index of the open pile, starting at 0
   * @return card topcard from open pile
   */
  public Card getOpenCardAt(int pileIndex) {
    OpenPile opile = open.get(pileIndex);
    Card ocard = opile.cards.get(0);
    return ocard;
  }

  /**
   * Helper method for getDeck, checks if deck is valid using freecell criteria. creates array
   * with all false values and sets them to true as they are "found" in deck.
   *
   * @param deck list of cards
   * @return boolean true id deck is valid, false otherwise
   */
  private boolean validateDeck(List<Card> deck) {

    // check size of array
    if (deck.size() != 52) {
      return false;
    }

    // initialize boolean array to check validity of each card
    boolean deckArray[][] = new boolean[4][13];

    for (int y = 0; y < 52; y++) {
      if (deck.get(y).getSuit() == Suit.CLUBS) {
        int arrayVal = deck.get(y).getValue() - 1;
        deckArray[0][arrayVal] = true;
      } else if (deck.get(y).getSuit() == Suit.HEARTS) {
        int arrayVal = deck.get(y).getValue() - 1;
        deckArray[1][arrayVal] = true;
      } else if (deck.get(y).getSuit() == Suit.DIAMONDS) {
        int arrayVal = deck.get(y).getValue() - 1;
        deckArray[2][arrayVal] = true;
      } else if (deck.get(y).getSuit() == Suit.SPADES) {
        int arrayVal = deck.get(y).getValue() - 1;
        deckArray[3][arrayVal] = true;
      } else {
        return false;
      }

    }


    for (int row = 0; row < deckArray.length; row++) {
      for (int col = 0; col < deckArray[row].length; col++) {
        if (!deckArray[row][col]) {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * Helper method to startGame, deals the deck in a round robin fashion based
   * on the given number of cascade piles.
   */
  private void deal() {
    int i = 0;
    int piles = getNumCascadePiles();
    int dsize = cardDeck.deckSize();
    while (dsize > 0) {
      Card c = cardDeck.removeLastCard();
      cascade.get(i).dealCard(c);
      i = (i + 1) % piles;
      dsize = cardDeck.deckSize();
    }
  }


}
