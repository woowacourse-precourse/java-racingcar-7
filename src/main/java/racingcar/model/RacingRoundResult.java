package racingcar.model;

import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public record RacingRoundResult(
    List<Car> movedCars
) {

  public static RacingRoundResult from(List<Car> movedCars) {
    return new RacingRoundResult(movedCars);
  }
}
