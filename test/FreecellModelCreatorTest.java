import org.junit.Test;


import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellMultimoveModel;

import cs3500.freecell.model.SimpleFreecellModel;

import static cs3500.freecell.model.FreecellModelCreator.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * class to test model creator.
 */
public class FreecellModelCreatorTest {

  FreecellModelCreator freecellModelCreator;


  // pass in null gametype
  @Test
  public void createNull() {
    assertNull(create(null));


  }

  // pass in single move gametype
  @Test
  public void createSingle() {
    assertEquals(SimpleFreecellModel.class,
            create(FreecellModelCreator.GameType.SINGLEMOVE).getClass());


  }

  // pass in multimove
  @Test
  public void createMulti() {
    assertEquals(FreecellMultimoveModel.class,
            create(FreecellModelCreator.GameType.MULTIMOVE).getClass());
  }
}
