import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

/**
 * Monitor test class.
 */
public class PillCounterMonitorTest {

  /**
   * You may think of this as representative of the client of a pill counter. It represents a heavy
   * usage of the pill counter, responding to an actual conveyer belt that is bottling a large
   * quantity of pill bottles of varying capacities.
   */

  @Test
  public void usage() {
    PillCounterMonitor pillCounterMonitor = new PillCounterMonitor(new LoggingPillCounter());
    boolean result = conveyerBelt(pillCounterMonitor);
    assertTrue(result);
  }

  private boolean conveyerBelt(PillCounterMonitor counter) {
    //make 100 bottles of 100 pills each
    for (int bottle = 0; bottle < 100; bottle += 1) {
      for (int pill = 0; pill < 100; pill += 1) {
        counter.addPill(1); //1 pill at a time
      }
      assertEquals(100, counter.getPillCount());
      counter.reset(); //for the next bottle
    }

    //make 1000 bottles of 20 pills each
    for (int bottle = 0; bottle < 1000; bottle += 1) {
      for (int pill = 0; pill < 20; pill += 4) {
        counter.addPill(4); //4 pills at a time (newer machine)
      }
      assertEquals(20, counter.getPillCount());
      counter.reset(); //for the next bottle
    }

    //make 500 bottles of 200 pills each
    for (int bottle = 0; bottle < 500; bottle += 1) {
      for (int pill = 0; pill < 200; pill += 2) {
        counter.addPill(2); //2 pills at a time (third machine)
      }
      assertEquals(200, counter.getPillCount());
      counter.reset(); //for the next bottle
    }

    // Print the count list.
    List<Integer> countList = counter.getCountList();
    for (Integer count : countList) {
      System.out.println(count);
    }
    return true;
  }
}