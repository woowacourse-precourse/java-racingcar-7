package racingcar.controller;

import java.util.List;
import racingcar.model.CarNameMap;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingRoundResult;
import racingcar.service.car.CarService;
import racingcar.service.racing.RacingService;
import racingcar.view.input.dto.RacingRequest;
import racingcar.view.output.OutputView;
import racingcar.view.output.dto.RacingResponse;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class RacingCarController {
  private final RacingService racingService;
  private final CarService carService;


  public RacingCarController(RacingService racingService, CarService carService) {
    this.racingService = racingService;
    this.carService = carService;
  }

  public RacingResponse run(RacingRequest racingRequest) {
    Cars cars = carService.createParticipants(racingRequest.carNames());
    Racing racing = racingService.open(cars, racingRequest.roundCount());

    OutputView.printExecuteResult();
    for (int i = 0; i < racing.getRoundCount(); ++i){
      RacingRoundResult roundResult = racingService.executeRound(racing);
      OutputView.printRoundResult(cars.getList());
    }

    return RacingResponse.from(
        racingService.retrieveWinners(racing));
  }
}
