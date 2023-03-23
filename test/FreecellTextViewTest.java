
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.Card;
import cs3500.freecell.model.Deck;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.Suit;
import cs3500.freecell.view.FreecellTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * class to test frecell text view.
 */
public class FreecellTextViewTest {


  SimpleFreecellController simpleFreecellController;
  FreecellTextView freecellTextView;
  FreecellModel<Card> freecellModel;
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
  Readable readable;
  Deck deck;


  @Before
  public void init() throws Exception {

    freecellModel = (new SimpleFreecellModel());

    freecellTextView = new FreecellTextView(freecellModel, appendable);
    validDeck = (new ArrayList<Card>());


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

    deck = new Deck(validDeck);
  }

  @Test
  public void renderMessage() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      freecellTextView = new FreecellTextView(freecellModel, stringBuilder);
      freecellTextView.renderMessage("hey");
      assertEquals(stringBuilder.toString(), "hey");

    } catch (IOException e) {
      fail();
    }

  }

  @Test(expected = IOException.class)
  public void badRenderMessage() throws IOException {

    MockAppendable mockAppendable = new MockAppendable();
    freecellTextView = new FreecellTextView(freecellModel, mockAppendable);
    freecellTextView.renderMessage("hey");


  }

  @Test
  public void renderBoard() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      StringReader stringReader = new StringReader("C2 13 O2\nq\n");
      appendable = System.out;
      freecellModel = new SimpleFreecellModel();
      freecellModel.startGame(validDeck, 4, 2, false);

      simpleFreecellController = new SimpleFreecellController(freecellModel, stringReader,
              appendable);
      freecellTextView = new FreecellTextView(freecellModel, stringBuilder);
      freecellTextView.renderBoard();

      assertEquals(stringBuilder.toString(), "F1:\n" +
              "F2:\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "O2:\n" +
              "C1: 13♦, 9♦, 5♦, 1♦, 10♥, 6♥, 2♥, 11♠, 7♠, 3♠, 12♣, 8♣, 4♣\n" +
              "C2: 12♦, 8♦, 4♦, 13♥, 9♥, 5♥, 1♥, 10♠, 6♠, 2♠, 11♣, 7♣, 3♣\n" +
              "C3: 11♦, 7♦, 3♦, 12♥, 8♥, 4♥, 13♠, 9♠, 5♠, 1♠, 10♣, 6♣, 2♣\n" +
              "C4: 10♦, 6♦, 2♦, 11♥, 7♥, 3♥, 12♠, 8♠, 4♠, 13♣, 9♣, 5♣, 1♣\n");

    } catch (Exception e) {
      fail();
    }
  }


  @Test(expected = IOException.class)
  public void badRenderBoard() throws IOException {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      StringReader stringReader = new StringReader("C2 13 O2\nq\n");
      appendable = new MockAppendable();
      freecellModel = new SimpleFreecellModel();
      freecellModel.startGame(validDeck, 4, 2, false);

      simpleFreecellController = new SimpleFreecellController(freecellModel, stringReader,
              appendable);
      freecellTextView = new FreecellTextView(freecellModel, appendable);
      freecellTextView.renderBoard();

      assertEquals(stringBuilder.toString(), "F1:\n" +
              "F2:\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "O2:\n" +
              "C1: 13♦, 9♦, 5♦, 1♦, 10♥, 6♥, 2♥, 11♠, 7♠, 3♠, 12♣, 8♣, 4♣\n" +
              "C2: 12♦, 8♦, 4♦, 13♥, 9♥, 5♥, 1♥, 10♠, 6♠, 2♠, 11♣, 7♣, 3♣\n" +
              "C3: 11♦, 7♦, 3♦, 12♥, 8♥, 4♥, 13♠, 9♠, 5♠, 1♠, 10♣, 6♣, 2♣\n" +
              "C4: 10♦, 6♦, 2♦, 11♥, 7♥, 3♥, 12♠, 8♠, 4♠, 13♣, 9♣, 5♣, 1♣\n");
    } catch (IOException i) {
      throw new IOException();

    } catch (Exception e) {
      fail();


    }


  }


}
