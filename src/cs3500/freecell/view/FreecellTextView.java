package cs3500.freecell.view;

import java.io.IOException;

import cs3500.freecell.model.FreecellModelState;

/**
 * Class representing a view for freecell text, must have constructor with
 * argument of FrecellModelStatus<?> that can be called with model object
 * to provide view to all methods -> query model and print board.
 */
public class FreecellTextView implements FreecellView {
  FreecellModelState<?> fMS;
  Appendable appendable;

  public FreecellTextView(FreecellModelState<?> fMS) {
    this.fMS = fMS;
  }

  public FreecellTextView(FreecellModelState<?> fMS, Appendable appendable) {
    this.fMS = fMS;
    this.appendable = appendable;
  }

  /**
   * method to turn card piles into string to view.
   *
   * @return string
   */
  @Override
  public String toString() {
    String pileView = "";

    // foundation pile
    for (int a = 0; a < 4; a++) {
      if (fMS.getNumCardsInFoundationPile(a) == 0) {
        pileView += "F" + (a + 1) + ":" + "\n";
      } else {
        pileView += "F" + (a + 1) + ": ";
        for (int b = 0; b < fMS.getNumCardsInFoundationPile(a); b++) {
          if (fMS.getFoundationCardAt(a, b) == fMS.getFoundationCardAt(
                  a, fMS.getNumCardsInFoundationPile(a) - 1)) {
            pileView += fMS.getFoundationCardAt(a, b).toString() + "\n";
          } else {
            pileView += fMS.getFoundationCardAt(a, b).toString() + ", ";
          }
        }
      }
    }


    // to string for open piles
    for (int d = 0; d < fMS.getNumOpenPiles(); d++) {
      if (fMS.getNumCardsInOpenPile(d) == 0) {
        pileView += "O" + (d + 1) + ":" + "\n";
      } else {
        pileView += "O" + (d + 1) + ": ";
        for (int b = 0; b < fMS.getNumCardsInOpenPile(d); b++) {
          if (fMS.getOpenCardAt(d) == fMS.getOpenCardAt(d)) {
            pileView += fMS.getOpenCardAt(d).toString() + "\n";
          } else {
            pileView += fMS.getOpenCardAt(d).toString() + ", ";
          }
        }
      }
    }

    for (int e = 0; e < fMS.getNumCascadePiles(); e++) {
      if (fMS.getNumCardsInCascadePile(e) == 0) {
        pileView += "C" + (e + 1) + ":" + "\n";
      } else {
        pileView += "C" + (e + 1) + ": ";
        for (int b = 0; b < fMS.getNumCardsInCascadePile(e); b++) {
          if (fMS.getCascadeCardAt(e, b) == fMS.getCascadeCardAt(
                  e, fMS.getNumCardsInCascadePile(e) - 1)) {
            pileView += fMS.getCascadeCardAt(e, b).toString() + "\n";
          } else {
            pileView += fMS.getCascadeCardAt(e, b).toString() + ", ";
          }
        }
      }
    }


    return pileView;
  }

  @Override
  public void renderBoard() throws IOException {
    try {
      if (appendable == null) {
        System.out.println(this);
      }
      if (appendable != null) {
        appendable.append(toString());
      }

    } catch (IOException exception) {
      throw new IOException("Could not render board");

    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      if (appendable == null) {
        System.out.println(message);

      }
      if (appendable != null) {
        appendable.append(message);
      }
    } catch (IOException exception) {
      throw new IOException("Could not render message");

    }

  }


}


