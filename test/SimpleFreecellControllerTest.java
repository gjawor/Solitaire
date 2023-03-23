import org.junit.Before;
import org.junit.Test;


import java.io.InputStreamReader;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.Deck;
import cs3500.freecell.model.FreecellModel;

import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.Suit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * class to test freecell controller.
 */
public class SimpleFreecellControllerTest {
  FreecellModel<Card> freecellModel;
  SimpleFreecellController simpleFreecellController;
  Readable readable;
  Appendable appendable;

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
  ArrayList<Card> multiDeck1;
  ArrayList<Card> perfectDeck;
  Deck deck;
  Deck multiDeck;


  @Before
  public void init() throws Exception {

    appendable = System.out;


    freecellModel = (new SimpleFreecellModel());


    validDeck = (new ArrayList<Card>());
    multiDeck1 = new ArrayList<Card>();
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

    multiDeck1.add(c1);
    multiDeck1.add(d13);
    multiDeck1.add(s12);
    multiDeck1.add(h11);
    multiDeck1.add(c2);
    multiDeck1.add(s10);
    multiDeck1.add(d8);
    multiDeck1.add(h4);
    multiDeck1.add(c3);
    multiDeck1.add(h8);
    multiDeck1.add(h12);
    multiDeck1.add(s3);
    multiDeck1.add(c4);
    multiDeck1.add(h1);
    multiDeck1.add(h2);
    multiDeck1.add(h3);
    multiDeck1.add(c5);
    multiDeck1.add(h5);
    multiDeck1.add(h6);
    multiDeck1.add(h7);
    multiDeck1.add(c6);
    multiDeck1.add(h9);
    multiDeck1.add(s11);
    multiDeck1.add(h10);
    multiDeck1.add(c7);
    multiDeck1.add(h13);
    multiDeck1.add(s1);
    multiDeck1.add(s2);
    multiDeck1.add(c8);
    multiDeck1.add(s4);
    multiDeck1.add(s5);
    multiDeck1.add(s6);
    multiDeck1.add(c9);
    multiDeck1.add(s8);
    multiDeck1.add(d2);
    multiDeck1.add(s9);
    multiDeck1.add(c10);
    multiDeck1.add(s7);
    multiDeck1.add(s13);
    multiDeck1.add(d1);
    multiDeck1.add(c11);
    multiDeck1.add(d3);
    multiDeck1.add(d4);
    multiDeck1.add(d5);
    multiDeck1.add(c12);
    multiDeck1.add(d7);
    multiDeck1.add(d6);
    multiDeck1.add(d9);
    multiDeck1.add(c13);
    multiDeck1.add(d11);
    multiDeck1.add(d12);
    multiDeck1.add(d10);


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


    deck = new Deck(validDeck);
    multiDeck = new Deck(multiDeck1);


  }

  //constructor tests
  @Test(expected = Exception.class)
  public void ConstructorTestNullModel() throws Exception {
    freecellModel = null;
    readable = new InputStreamReader(System.in);
    appendable = System.out;
    simpleFreecellController = new SimpleFreecellController(freecellModel, readable, appendable);

  }

  @Test(expected = Exception.class)
  public void ConstructorTestNullReadable() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    readable = null;
    appendable = System.out;
    simpleFreecellController = new SimpleFreecellController(freecellModel, readable, appendable);

  }

  @Test(expected = Exception.class)
  public void ConstructorTestNullAppendable() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    readable = new InputStreamReader(System.in);
    appendable = null;
    simpleFreecellController = new SimpleFreecellController(freecellModel, readable, appendable);

  }

  // play game
  @Test(expected = Exception.class)
  public void playGameNullDeck() {
    readable = new InputStreamReader(System.in);
    appendable = System.out;
    simpleFreecellController = new SimpleFreecellController(freecellModel, readable, appendable);
    simpleFreecellController.playGame(null, 4, 2, false);

  }

  @Test(expected = Exception.class)
  public void playGameBadCascade() {
    simpleFreecellController.playGame(validDeck, 9, 2, false);

  }

  @Test(expected = Exception.class)
  public void playGameBadCascadeNeg() {
    simpleFreecellController.playGame(validDeck, -4, 2, false);

  }

  @Test(expected = Exception.class)
  public void playGameBadOpen() {
    simpleFreecellController.playGame(validDeck, 4, 5, false);

  }

  @Test(expected = Exception.class)
  public void playGameBadOpenNeg() {
    simpleFreecellController.playGame(validDeck, 4, -7, false);

  }

  @Test(expected = Exception.class)
  public void playGameBadCascadeAndOpen() {
    simpleFreecellController.playGame(validDeck, 10, -7, true);

  }


  @Test
  public void quitEarly() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("q");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);
      assertTrue(s.toString().contains("game quit prematurely"));

    } catch (IllegalArgumentException e) {
      fail();

    }
  }

  @Test
  public void quitEarlyQ() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("q");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);
      assertTrue(s.toString().contains("game quit prematurely"));

    } catch (IllegalArgumentException e) {
      fail();

    }
  }

  @Test
  public void gameOver() {
    freecellModel = new SimpleFreecellModel();
    StringReader stringReader = new StringReader("C1 13 F1 C1 12 F1 C1 11 F1 C1 10 F1 C1 9 " +
            "F1 C1 8 F1 C1 7 F1 C1 6 F1 C1 5 F1 C1 4 F1 C1 3 F1 C1 2 F1 C1 1 F1 " +
            "C2 13 F2 C2 12 F2 C2 11 F2 C2 10 F2 C2 9 + F2 C2 8 F2 C2 7 F2 C2 6 F2 C2 5 F2" +
            " C2 4 F2 C2 3 F2 C2 2 F2 C2 1 F2 C3 13 F3 C3 12 F3 C3 11 F3 C3 10 F3 C3 9 " +
            " F3 C3 8 F3 C3 7 F3 C3 6 F3 C3 5 F3 C3 4 F3 C3 3 F3 C3 2 F3 C3 1 F3" +
            " C4 13 F4 C4 12 F4 C4 11 F4 C4 10 F4 C4 9 \" +\n" +
            " F4 C4 8 F4 C4 7 F4 C4 6 F4 C4 5 F4 C4 4 F4 C4 3 F4 C4 2 F4 C4 1 F4 \n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(perfectDeck, 4, 2, false);
      assertTrue(s.toString().contains("game over all foundation piles have been filled"));

    } catch (IllegalArgumentException e) {
      fail();

    }

  }

  //valid moves


  @Test(expected = NoSuchElementException.class)
  public void moveCardCO() {
    freecellModel = new SimpleFreecellModel();
    StringReader stringReader = new StringReader("C2 13 O2 \n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel, stringReader,
              appendable);
      simpleFreecellController.playGame(validDeck, 4, 2, false);
    } catch (IllegalArgumentException e) {

      assertEquals(1, freecellModel.getNumCardsInOpenPile(1));
    }
  }

  // move card from cascade to foundation
  @Test(expected = NoSuchElementException.class)
  public void moveCardCF() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C4 13 F1 \n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(validDeck, 4, 2, false);

    } catch (IllegalArgumentException e) {
      assertEquals(1, freecellModel.getNumCardsInFoundationPile(1));

    }


  }


  @Test(expected = NoSuchElementException.class)
  public void moveCardCC() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 C3\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    } catch (IllegalArgumentException e) {
      assertEquals(1, freecellModel.getNumCardsInFoundationPile(1));

    }

  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardOF() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C4 13 O1 O1 1 F1\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(validDeck, 4, 2, false);


    } catch (IllegalArgumentException e) {
      assertEquals(1, freecellModel.getNumCardsInFoundationPile(1));

    }

  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardOC() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 O1 O1 1 C3\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    } catch (IllegalArgumentException e) {
      assertEquals(14, freecellModel.getNumCardsInCascadePile(2));
    }


  }

  @Test
  public void movethenQuit() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 O1 q O1 1 C3\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);
      assertTrue(s.toString().contains("game quit prematurely"));

    } catch (IllegalArgumentException e) {
      fail();

    }


  }

  @Test
  public void quitDuringMove() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 q 13 O1 O1 1 C3\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);
      assertTrue(s.toString().contains("game quit prematurely"));

    } catch (IllegalArgumentException e) {
      fail();

    }


  }

  @Test
  public void quitDuringMove2() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 Q O1 O1 1 C3\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);
      assertTrue(s.toString().contains("game quit prematurely"));

    } catch (IllegalArgumentException e) {
      fail();
    }


  }


  // invalid moves

  @Test(expected = NoSuchElementException.class)
  public void moveCardFO() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 O1 O1 1 F1\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    simpleFreecellController = new SimpleFreecellController(freecellModel,
            stringReader, appendable);
    simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    assertTrue(s.toString().contains("invalid move"));


  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardCFBad() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C1 13 F1\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    simpleFreecellController = new SimpleFreecellController(freecellModel,
            stringReader, appendable);
    simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    assertTrue(s.toString().contains("invalid move"));


  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardCOBad() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C2 13 O2 C3 13 O2\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    simpleFreecellController = new SimpleFreecellController(freecellModel,
            stringReader, appendable);
    simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    assertTrue(s.toString().contains("invalid move"));


  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardCCBad() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C3 13 C2\n");
    StringBuilder s = new StringBuilder();
    appendable = s;

    simpleFreecellController = new SimpleFreecellController(freecellModel,
            stringReader, appendable);
    simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    assertTrue(s.toString().contains("invalid move"));


  }

  // varied inputs to make sure controller is throwing out bad invalid inputs
  @Test(expected = NoSuchElementException.class)
  public void moveCardExtraInputSource() {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader(" x G7 C2\n 13 O2\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);


    } catch (IllegalArgumentException e) {
      assertEquals(1, freecellModel.getNumCardsInOpenPile(1));

    }


  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardExtraInputIndex() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader("C3 nice pie\t 13 C2\n");
    appendable = System.out;

    simpleFreecellController = new SimpleFreecellController(freecellModel,
            stringReader, appendable);
    simpleFreecellController.playGame(multiDeck1, 4, 2, false);

    assertEquals(14, freecellModel.getNumCardsInCascadePile(1));


  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardExtraInputDest() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader(" C3 13 l 12 C2\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);


    } catch (IllegalArgumentException e) {
      assertEquals(14, freecellModel.getNumCardsInCascadePile(1));
    }

  }

  @Test(expected = NoSuchElementException.class)
  public void moveCardExtraInputTabNewLine() throws Exception {
    freecellModel = (new SimpleFreecellModel());
    StringReader stringReader = new StringReader(" C3 \n 13 l \t 12\t C2\n");
    appendable = System.out;

    try {
      simpleFreecellController = new SimpleFreecellController(freecellModel,
              stringReader, appendable);
      simpleFreecellController.playGame(multiDeck1, 4, 2, false);


    } catch (IllegalArgumentException e) {
      assertEquals(14, freecellModel.getNumCardsInCascadePile(1));
    }

  }

}
