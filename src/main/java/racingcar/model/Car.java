package racingcar.model;

import racingcar.util.RandomNumberGenerator;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class Car implements Comparable<Car>{
  private String name;
  private int position;

  public String getName() {
    return this.name;
  }

  public int getPosition() {
    return this.position;
  }

  private boolean canMove(RandomNumberGenerator randomNumberGenerator) {
    int randomNumber = randomNumberGenerator.generate();
    return randomNumber >= 4;
  }

  public void moveOrStay(RandomNumberGenerator randomNumberGenerator) {
    if (canMove(randomNumberGenerator)){
      position++;
    }
  }

  @Override
  public int compareTo(Car o) {
    return Integer.compare(this.position, o.position);
  }
}
