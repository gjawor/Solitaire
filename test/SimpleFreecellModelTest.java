
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import cs3500.freecell.model.Card;
import cs3500.freecell.model.Deck;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.Suit;
import cs3500.freecell.model.SimpleFreecellModel;

/**
 * class to test a simple freecell model (single move).
 */
public class SimpleFreecellModelTest {

  // initialization of cards, lists of piles, piles, and decks

  // clubs
  Card c1 = (new Card(Suit.CLUBS, 1));
  Card c2 = (new Card(Suit.CLUBS, 2));
  Card c3 = (new Card(Suit.CLUBS, 3));
  Card c4 = (new Card(Suit.CLUBS, 4));
  Card c5 = (new Card(Suit.CLUBS, 5));
  Card c6 = (new Card(Suit.CLUBS, 6));
  Card c7 = (new Card(Suit.CLUBS, 7));
  Card c8 = (new Card(Suit.CLUBS, 8));
  Card c9 = (new Card(Suit.CLUBS, 9));
  Card c10 = (new Card(Suit.CLUBS, 10));
  Card c11 = (new Card(Suit.CLUBS, 11));
  Card c12 = (new Card(Suit.CLUBS, 12));
  Card c13 = (new Card(Suit.CLUBS, 13));

  // spades
  Card s1 = (new Card(Suit.SPADES, 1));
  Card s2 = (new Card(Suit.SPADES, 2));
  Card s3 = (new Card(Suit.SPADES, 3));
  Card s4 = (new Card(Suit.SPADES, 4));
  Card s5 = (new Card(Suit.SPADES, 5));
  Card s6 = (new Card(Suit.SPADES, 6));
  Card s7 = (new Card(Suit.SPADES, 7));
  Card s8 = (new Card(Suit.SPADES, 8));
  Card s9 = (new Card(Suit.SPADES, 9));
  Card s10 = (new Card(Suit.SPADES, 10));
  Card s11 = (new Card(Suit.SPADES, 11));
  Card s12 = (new Card(Suit.SPADES, 12));
  Card s13 = (new Card(Suit.SPADES, 13));

  // diamonds
  Card d1 = (new Card(Suit.DIAMONDS, 1));
  Card d2 = (new Card(Suit.DIAMONDS, 2));
  Card d3 = (new Card(Suit.DIAMONDS, 3));
  Card d4 = (new Card(Suit.DIAMONDS, 4));
  Card d5 = (new Card(Suit.DIAMONDS, 5));
  Card d6 = (new Card(Suit.DIAMONDS, 6));
  Card d7 = (new Card(Suit.DIAMONDS, 7));
  Card d8 = (new Card(Suit.DIAMONDS, 8));
  Card d9 = (new Card(Suit.DIAMONDS, 9));
  Card d10 = (new Card(Suit.DIAMONDS, 10));
  Card d11 = (new Card(Suit.DIAMONDS, 11));
  Card d12 = (new Card(Suit.DIAMONDS, 12));
  Card d13 = (new Card(Suit.DIAMONDS, 13));

  // hearts
  Card h1 = (new Card(Suit.HEARTS, 1));
  Card h2 = (new Card(Suit.HEARTS, 2));
  Card h3 = (new Card(Suit.HEARTS, 3));
  Card h4 = (new Card(Suit.HEARTS, 4));
  Card h5 = (new Card(Suit.HEARTS, 5));
  Card h6 = (new Card(Suit.HEARTS, 6));
  Card h7 = (new Card(Suit.HEARTS, 7));
  Card h8 = (new Card(Suit.HEARTS, 8));
  Card h9 = (new Card(Suit.HEARTS, 9));
  Card h10 = (new Card(Suit.HEARTS, 10));
  Card h11 = (new Card(Suit.HEARTS, 11));
  Card h12 = (new Card(Suit.HEARTS, 12));
  Card h13 = (new Card(Suit.HEARTS, 13));

  ArrayList<Card> validDeck;
  ArrayList<Card> badDeck;
  ArrayList<Card> perfectDeck;
  Deck goodDeck;
  Deck fakeDeck;

  FreecellModel freecellModel;


  @Before
  public void init() {
    validDeck = (new ArrayList<Card>());
    badDeck = (new ArrayList<Card>());
    perfectDeck = new ArrayList<Card>();

    validDeck.add(c1);
    validDeck.add(c2);
    validDeck.add(c3);
    validDeck.add(c4);
    validDeck.add(c5);
    validDeck.add(c6);
    validDeck.add(c7);
    validDeck.add(c8);
    validDeck.add(c9);
    validDeck.add(c10);
    validDeck.add(c11);
    validDeck.add(c12);
    validDeck.add(c13);
    validDeck.add(s1);
    validDeck.add(s2);
    validDeck.add(s3);
    validDeck.add(s4);
    validDeck.add(s5);
    validDeck.add(s6);
    validDeck.add(s7);
    validDeck.add(s8);
    validDeck.add(s9);
    validDeck.add(s10);
    validDeck.add(s11);
    validDeck.add(s12);
    validDeck.add(s13);
    validDeck.add(h1);
    validDeck.add(h2);
    validDeck.add(h3);
    validDeck.add(h4);
    validDeck.add(h5);
    validDeck.add(h6);
    validDeck.add(h7);
    validDeck.add(h8);
    validDeck.add(h9);
    validDeck.add(h10);
    validDeck.add(h11);
    validDeck.add(h12);
    validDeck.add(h13);
    validDeck.add(d1);
    validDeck.add(d2);
    validDeck.add(d3);
    validDeck.add(d4);
    validDeck.add(d5);
    validDeck.add(d6);
    validDeck.add(d7);
    validDeck.add(d8);
    validDeck.add(d9);
    validDeck.add(d10);
    validDeck.add(d11);
    validDeck.add(d12);
    validDeck.add(d13);

    goodDeck = new Deck(validDeck);

    badDeck.add(c1);
    badDeck.add(c2);
    badDeck.add(c3);
    badDeck.add(c4);
    badDeck.add(h3);
    badDeck.add(c6);
    badDeck.add(c7);
    badDeck.add(c8);
    badDeck.add(c9);
    badDeck.add(c10);
    badDeck.add(c11);
    badDeck.add(c12);
    badDeck.add(c13);
    badDeck.add(s1);
    badDeck.add(s2);
    badDeck.add(s3);
    badDeck.add(s4);
    badDeck.add(s5);
    badDeck.add(s6);
    badDeck.add(s7);
    badDeck.add(s8);
    badDeck.add(s9);
    badDeck.add(s10);
    badDeck.add(s11);
    badDeck.add(s12);
    badDeck.add(s13);
    badDeck.add(h1);
    badDeck.add(h2);
    badDeck.add(h5);
    badDeck.add(h4);
    badDeck.add(c5);
    badDeck.add(h6);
    badDeck.add(c7);
    badDeck.add(h8);
    badDeck.add(h9);
    badDeck.add(h10);
    badDeck.add(h11);
    badDeck.add(h12);
    badDeck.add(h13);
    badDeck.add(d1);
    badDeck.add(d2);
    badDeck.add(d3);
    badDeck.add(d4);
    badDeck.add(d5);
    badDeck.add(d6);
    badDeck.add(d7);
    badDeck.add(d8);
    badDeck.add(d9);
    badDeck.add(d10);
    badDeck.add(d11);
    badDeck.add(d12);
    badDeck.add(c13);

    perfectDeck.add(c1);
    perfectDeck.add(h1);
    perfectDeck.add(s1);
    perfectDeck.add(d1);
    perfectDeck.add(c2);
    perfectDeck.add(h2);
    perfectDeck.add(s2);
    perfectDeck.add(d2);
    perfectDeck.add(c3);
    perfectDeck.add(h3);
    perfectDeck.add(s3);
    perfectDeck.add(d3);
    perfectDeck.add(c4);
    perfectDeck.add(h4);
    perfectDeck.add(s4);
    perfectDeck.add(d4);
    perfectDeck.add(c5);
    perfectDeck.add(h5);
    perfectDeck.add(s5);
    perfectDeck.add(d5);
    perfectDeck.add(c6);
    perfectDeck.add(h6);
    perfectDeck.add(s6);
    perfectDeck.add(d6);
    perfectDeck.add(c7);
    perfectDeck.add(h7);
    perfectDeck.add(s7);
    perfectDeck.add(d7);
    perfectDeck.add(c8);
    perfectDeck.add(h8);
    perfectDeck.add(s8);
    perfectDeck.add(d8);
    perfectDeck.add(c9);
    perfectDeck.add(h9);
    perfectDeck.add(s9);
    perfectDeck.add(d9);
    perfectDeck.add(c10);
    perfectDeck.add(h10);
    perfectDeck.add(s10);
    perfectDeck.add(d10);
    perfectDeck.add(c11);
    perfectDeck.add(h11);
    perfectDeck.add(s11);
    perfectDeck.add(d11);
    perfectDeck.add(c12);
    perfectDeck.add(h12);
    perfectDeck.add(s12);
    perfectDeck.add(d12);
    perfectDeck.add(c13);
    perfectDeck.add(h13);
    perfectDeck.add(s13);
    perfectDeck.add(d13);

    fakeDeck = new Deck(badDeck);

    freecellModel = new SimpleFreecellModel();

  }


  //move
  @Test
  public void moveCascadeToFoundation() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 0);
    assertEquals(c1, freecellModel.getFoundationCardAt(0, 0));


  }

  //move
  @Test
  public void moveCascadeToOpen() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 2);
    assertEquals(c4, freecellModel.getOpenCardAt(2));

  }

  //move
  @Test
  public void moveCascadeToCascade() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 3, 12, PileType.OPEN, 1);
    freecellModel.move(PileType.CASCADE, 3, 11, PileType.CASCADE, 0);
    assertEquals(c4, freecellModel.getCascadeCardAt(0, 12));


  }

  // move
  @Test
  public void moveOpenToFoundation() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 3, 12, PileType.OPEN, 1);
    freecellModel.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 0);
    assertEquals(c1, freecellModel.getFoundationCardAt(0, 0));

  }

  @Test(expected = RuntimeException.class)
  public void moveCascadeToFoundationBad() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 1);


  }

  @Test(expected = RuntimeException.class)
  public void moveCascadeToOpenBad() {
    freecellModel.startGame(validDeck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 3, 12, PileType.OPEN, 1);
    freecellModel.move(PileType.CASCADE, 2, 12, PileType.OPEN, 1);

  }

  @Test(expected = RuntimeException.class)
  public void moveCascadeToCascadeBad() {
    freecellModel.startGame(validDeck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 0);

  }


}
