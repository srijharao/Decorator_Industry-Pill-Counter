/**
 * Pill Counter for batch operations.
 */
public class LazyPillCounter extends PillCounterDecorator {

  private int count;

  /**
   * Initializes Pill counter and count.
   *
   * @param counter Pill counter
   */
  public LazyPillCounter(PillCounter counter) {
    super(counter);
    this.count = 0;
  }

  @Override
  public void addPill(int count) {
    this.count += count;
  }

  @Override
  public void removePill() {
    this.count--;
  }

  @Override
  public int getPillCount() {
    lazyUpdate();
    return super.getPillCount();
  }

  @Override
  public void reset() {
    lazyUpdate();
    super.reset();
  }

  /**
   * Below method is to ensure that the logging is consistent.
   */
  private void lazyUpdate() {
    if (this.count > 0) {
      super.addPill(this.count);
    } else if (this.count < 0) {
      while (count != 0) {
        super.removePill();
        count++;
      }
    }
    this.count = 0;
  }
}
