package cs3500.freecell.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.freecell.model.Card;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.Suit;
import cs3500.freecell.view.FreecellTextView;


/**
 * Class to represent a controller between a freecell model and freecell text view.
 */
public class SimpleFreecellController implements FreecellController<Card> {
  Readable readable;
  Appendable appendable;
  FreecellModel<Card> freecellModel;
  FreecellTextView freecellTextView;
  IOException e;


  /**
   * Constructor to create a new freecell game.
   * @param freecellModel multilove or single move
   * @param readable input
   * @param appendable output
   * @throws IllegalArgumentException null input
   */
  public SimpleFreecellController(FreecellModel<Card> freecellModel, Readable readable,
                                  Appendable appendable) throws IllegalArgumentException {
    this.readable = readable;
    this.appendable = appendable;
    this.freecellModel = freecellModel;
    this.freecellTextView = new FreecellTextView(freecellModel, appendable);
    if (freecellModel == null || readable == null || appendable == null) {
      throw new IllegalArgumentException("cannot accept null arguments");
    }


  }


  /**
   * Start and play a new game of freecell with the provided deck. This deck
   * should be used as-is. This method returns only when the game is over
   * (either by winning or by quitting).
   *
   * @param deck        the deck to be used to play this game
   * @param numCascades the number of cascade piles
   * @param numOpens    the number of open piles
   * @param shuffle     shuffle the deck if true, false otherwise
   */
  public void playGame(List<Card> deck, int numCascades, int numOpens, boolean shuffle)
          throws IllegalStateException {

    String currentInput = null;

    try {
      freecellModel.startGame(deck, numCascades, numOpens, shuffle);
      freecellTextView.renderBoard();
      freecellTextView.renderMessage("\n");
      Scanner scanner = new Scanner(readable);

      String source = null;
      Integer index = null;
      String destination = null;
      PileType sourcePile = null;
      Integer sourceNum = null;
      PileType destPile = null;
      Integer destNum = null;


      do {
        currentInput = scanner.next();
        if (currentInput.equalsIgnoreCase("Q")) {
          break;
        }

        if (source == null) {
          Character c = currentInput.charAt(0);
          String pileNum = currentInput.substring(1);


          if (c.equals('C') || c.equals('F') || c.equals('O') && isInt(pileNum)) {

            sourceNum = Integer.parseInt(pileNum) - 1;
            source = "found";

            if (c.equals('C')) {
              sourcePile = PileType.CASCADE;
            } else if (c.equals('F')) {
              sourcePile = PileType.FOUNDATION;
            } else {
              sourcePile = PileType.OPEN;
            }


          }

        } else if (index == null) {

          if (isInt(currentInput)) {
            int currentInputInt = Integer.parseInt(currentInput);
            index = currentInputInt - 1;

          }

        } else if (destination == null) {
          Character d = currentInput.charAt(0);
          String dPileNum = currentInput.substring(1);
          if (d.equals('C') || d.equals('F') || d.equals('O') && isInt(dPileNum)) {

            destNum = Integer.parseInt(dPileNum) - 1;
            destination = "found";


            if (d.equals('C')) {
              destPile = PileType.CASCADE;
            } else if (d.equals('F')) {
              destPile = PileType.FOUNDATION;
            } else {
              destPile = PileType.OPEN;
            }
            try {
              freecellModel.move(sourcePile, sourceNum, index, destPile, destNum);
            } catch (IllegalArgumentException e) {
              freecellTextView.renderMessage("invalid move \n");
            }


            freecellTextView.renderBoard();
            freecellTextView.renderMessage("\n");
            source = null;
            index = null;
            destination = null;


          }

        }

      }
      while (!currentInput.equalsIgnoreCase("Q") && scanner.hasNext());

    } catch (RuntimeException e) {
      try {
        freecellTextView.renderMessage(e.getMessage());
      } catch (IOException i) {
        throw new IllegalStateException();
      }

    } catch (IOException i) {
      throw new IllegalStateException();
    }
    // game over
    if (freecellModel.isGameOver()) {
      try {
        freecellTextView.renderMessage("game over all foundation piles have been filled");
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } else if (currentInput.equals("q") || currentInput.equals("Q")) {
      try {
        freecellTextView.renderMessage("game quit prematurely");
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    } else {
      // if no more input but game is not over nor q entered
      throw new NoSuchElementException();
    }


  }

  /**
   * checks if the input is an integer.
   * @param s string from user input
   * @return true is int, false if not
   */
  private boolean isInt(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }


  /**
   * main method to test playability of game.
   * @param args input to test freecell
   */
  public static void main(String[] args) {
    // create model
    FreecellModel<Card> freecellModel = (new SimpleFreecellModel());
    // create readable and appendable
    Readable readable = new InputStreamReader(System.in);
    Appendable appendable = System.out;

    SimpleFreecellController simpleFreecellController = null;
    try {
      simpleFreecellController = (new SimpleFreecellController(freecellModel,
              readable, appendable));
    } catch (Exception e) {
      e.printStackTrace();
    }


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

    ArrayList<Card> validDeck = (new ArrayList<Card>());
    ArrayList<Card> multiDeck1 = new ArrayList<Card>();
    ArrayList<Card> perfectDeck = new ArrayList<Card>();

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


    simpleFreecellController.playGame(perfectDeck, 4, 4, false);


  }
}
