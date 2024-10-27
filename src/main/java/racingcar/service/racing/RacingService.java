package racingcar.service.racing;

import racingcar.model.Cars;
import racingcar.model.Racing;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class RacingService {

  public Racing open(Cars cars, int roundCount){
    return Racing.from(cars, roundCount);
  }
}
