package racingcar.model;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomNumberGeneratorImpl;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class Car implements Comparable<Car>{
  private String name;
  private int position;
  private RandomNumberGenerator randomNumberGenerator;

  private Car(String carName) {
    this.name = carName;
    this.position = 0;
    randomNumberGenerator = new RandomNumberGeneratorImpl();
  }

  public static Car from(String carName) {
    return new Car(carName);
  }

  public String getName() {
    return this.name;
  }

  public int getPosition() {
    return this.position;
  }

  private boolean canMove() {
    int randomNumber = randomNumberGenerator.generate();
    return randomNumber >= 4;
  }

  public void move (){
    this.position++;
  }

  public HasCarMoved moveOrStay() {
    boolean hasMoved = canMove();
    if (hasMoved){
      move();
    }
    return HasCarMoved.from(hasMoved);
  }

  @Override
  public int compareTo(Car o) {
    return Integer.compare(this.position, o.position);
  }

}
