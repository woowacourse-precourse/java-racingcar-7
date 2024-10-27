package racingcar.service.racing;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingRoundResult;
import racingcar.view.output.dto.RacingResponse;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class RacingService {

  public Racing open(Cars cars, int roundCount){
    return Racing.from(cars, roundCount);
  }

  public List<Car> retrieveWinners(Racing racing) {
    return racing.retrieveWinners();
  }

  public RacingRoundResult executeRound(Racing racing) {
      return racing.executeRound();
  }
}
