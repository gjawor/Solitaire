package cs3500.freecell.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a multimove model for a game of freecell. has added capability to move
 * multiple cards at once.
 */
public class FreecellMultimoveModel extends CardFreecellModel {


  public FreecellMultimoveModel() {
    super();
  }


  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
                   int destPileNumber) {
    try {
      int pileSize = getNumCardsInCascadePile(pileNumber);

      if (source == PileType.CASCADE) {
        // create new array list of cards to see if they make a build
        ArrayList<Card> build = new ArrayList<Card>();

        // fill build with elements
        for (int x = cardIndex; x < pileSize; x++) {
          Card bcard = this.getCascadeCardAt(pileNumber, x);
          build.add(bcard);
        }

        // find the number of empty cascade piles
        int emptyCascadePiles = 0;
        for (int c = 0; c < this.getNumCascadePiles(); c++) {
          if (this.getNumCardsInCascadePile(c) == 0) {
            emptyCascadePiles++;
          }
        }

        // takes out an empty cascade pile if the destination is cascade and empty
        if (destination == PileType.CASCADE && this.getNumCardsInCascadePile(destPileNumber) == 0) {
          emptyCascadePiles--;
        }

        // find the number of empty open piles
        int emptyOpenPiles = 0;
        for (int o = 0; o < this.getNumOpenPiles(); o++) {
          if (this.getNumCardsInOpenPile(o) == 0) {
            emptyOpenPiles++;
          }
        }

        int buildSize = build.size();
        // formula to determine max number of cards you can move in multi move
        double moveCards = (1 + emptyOpenPiles) * Math.pow(2, emptyCascadePiles);


        // check if buildsize is less than max num of movable cards
        if (buildSize < moveCards) {
          // check if build is valid
          validBuild(build);
          if (validBuild(build)) {
            // remove all
            this.cascade.get(pileNumber).removeBuild(cardIndex);
            // add build to destination pile
            if (destination == PileType.CASCADE) {
              cascade.get(destPileNumber).addBuild(build);

            } else if (destination == PileType.FOUNDATION) {
              if (buildSize == 1) {
                foundation.get(destPileNumber).addCard(build.get(0));
              } else {
                throw new IllegalArgumentException("invalid move -- can only move one card at a " +
                        "time to foundation piles");
              }

            } else if (destination == PileType.OPEN) {
              if (buildSize == 1) {
                open.get(destPileNumber).addCard(build.get(0));
              } else {
                throw new IllegalArgumentException("invalid move -- can only have one card at a" +
                        " time in an open pile");
              }
            }

          } else {
            throw new IllegalArgumentException("not a valid build");
          }
        } else {
          throw new IllegalArgumentException("not enough empty open or cascade piles for this" +
                  " move ");
        }
      } else if (source == PileType.FOUNDATION) {
        throw new IllegalArgumentException("can't move a card from the foundation pile");

      } else if (source == PileType.OPEN) {
        Card moveCard = getOpenCardAt(pileNumber);
        open.get(pileNumber).removeCard();
        if (destination == PileType.CASCADE) {
          cascade.get(destPileNumber).addCard(moveCard);
        } else if (destination == PileType.FOUNDATION) {
          foundation.get(destPileNumber).addCard(moveCard);
        } else if (destination == PileType.OPEN) {
          open.get(destPileNumber).addCard(moveCard);
        }
      }
    } catch (RuntimeException e) {
      throw new IllegalArgumentException(e.getMessage());
    }

  }

  /**
   * Checks if the created build is valid before it can be moved.
   *
   * @param build list of cards with at least one card
   * @return true if valid, false if not
   */
  private boolean validBuild(List<Card> build) {
    if (build.size() != 1) {
      for (int b = 0; b < build.size() - 1; b++) {
        Suit build1 = build.get(b).getSuit();
        Suit build2 = build.get(b + 1).getSuit();
        int value1 = build.get(b).getValue();
        int value2 = build.get(b + 1).getValue();

        if (value1 != value2 + 1 || (build1 == Suit.CLUBS || build1 == Suit.SPADES) &&
                (build2 != Suit.DIAMONDS && build2 != Suit.HEARTS)) {
          return false;

        } else if (value1 != value2 + 1 || (build1 == Suit.DIAMONDS || build1 == Suit.HEARTS) &&
                (build2 != Suit.CLUBS && build2 != Suit.SPADES)) {
          return false;

        }
      }
    }
    return true;
  }


}
