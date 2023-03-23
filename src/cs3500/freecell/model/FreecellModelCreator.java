package cs3500.freecell.model;



/**
 * Factory class to choose between a simple or multimove freecell model.
 */
public class FreecellModelCreator {




  /**
   * empty constructor -- only static methods.
   */
  private FreecellModelCreator() {
  }

  /**
   * initialize gametype enum for model creator.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE
  }

  /**
   * Creates a new freecell model game either single or multimove.
   *
   * @param gameType single or multimove
   * @return new instance of game model
   */
  public static FreecellModel<Card> create(GameType gameType) {
    if (gameType == GameType.SINGLEMOVE) {
      return new SimpleFreecellModel();
    } else if (gameType == GameType.MULTIMOVE) {
      return new FreecellMultimoveModel();
    } else {
      return null;
    }


  }
}
