import java.util.ArrayList;
import java.util.List;

/**
 * This class will monitor the number of times pills are added to a pill counter before it is reset
 * (this would monitor how many times the pill counter is used while filling one bottle).
 */
public class PillCounterMonitor extends PillCounterDecorator {

  private final List<Integer> countList;
  private int count;

  /**
   * Constructor initializes counter and list.
   *
   * @param counter PillCounter
   */
  public PillCounterMonitor(PillCounter counter) {
    super(counter);
    countList = new ArrayList<>();
    this.count = 0;
  }

  @Override
  public void addPill(int count) {
    super.addPill(count);
    this.count += 1;
  }

  @Override
  public void removePill() {
    super.removePill();
    this.count -= 1;
  }

  @Override
  public void reset() {
    countList.add(this.count);
    this.count = 0;
    super.reset();
  }

  /**
   * Returns reset count in a list.
   * @return array list of pill counter
   */
  public List<Integer> getCountList() {
    return new ArrayList<>(countList);
  }
}
