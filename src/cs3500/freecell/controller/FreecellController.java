package cs3500.freecell.controller;

import java.util.List;

/**
 * Interface for the freecell game controller. An implementation will work with
 * the IFreeCellModel interface to provide a game of freecell
 */
public interface FreecellController<K> {

  /**
   * Start and play a new game of freecell with the provided deck. This deck should be used as-is.
   * This method returns only when the game is over (either by winning or by quitting).
   * @param deck list of cards
   * @param numCascades cascade piles (4-8)
   * @param numOpens open piles (1-4)
   * @param shuffle true/false
   *
   */
  void playGame(List<K> deck, int numCascades, int numOpens, boolean shuffle);

}

