package cs3500.freecell.model;

/**
 * Class implementing FrecellModel<Card></Card> specified for card implementation.
 */
public class SimpleFreecellModel extends CardFreecellModel {


  public SimpleFreecellModel() {
    super();

  }


  @Override
  public void move(PileType source, int pileNumber, int cardIndex,
                   PileType destination, int destPileNumber) throws IllegalArgumentException {

    try {
      if (source == PileType.CASCADE) {
        Card moveCard = getCascadeCardAt(pileNumber, cardIndex);
        cascade.get(pileNumber).removeCard();
        if (destination == PileType.CASCADE) {
          cascade.get(destPileNumber).addCard(moveCard);
        } else if (destination == PileType.FOUNDATION) {
          foundation.get(destPileNumber).addCard(moveCard);
        } else if (destination == PileType.OPEN) {
          open.get(destPileNumber).addCard(moveCard);
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

}
