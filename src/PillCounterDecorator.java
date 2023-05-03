/**
 * Decorator class for pill counter.
 */
public class PillCounterDecorator implements PillCounter {

  private final PillCounter counter;

  /**
   * Initializes pillcounter.
   *
   * @param counter Pill Counter
   */
  public PillCounterDecorator(PillCounter counter) {
    this.counter = counter;
  }

  @Override
  public void addPill(int count) {
    counter.addPill(count);
  }

  @Override
  public void removePill() {
    counter.removePill();
  }

  @Override
  public void reset() {
    counter.reset();
  }

  @Override
  public int getPillCount() {
    return counter.getPillCount();
  }
}
