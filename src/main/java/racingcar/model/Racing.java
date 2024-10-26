package racingcar.model;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 26.
 */
public class Racing {
  Cars cars;
  int roundCount;

  private Racing (Cars cars, int roundCount){
    this.cars = cars;
    this.roundCount = roundCount;
  }

  public static Racing from(Cars cars, int roundCount) {
    return new Racing(cars, roundCount);
  }

}
