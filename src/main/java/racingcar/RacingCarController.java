package racingcar;

import java.util.List;
import racingcar.domain.car.RandomMovementStrategy;
import racingcar.service.RaceResult;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private static final String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView,
                               OutputView outputView,
                               RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }


    public void process() {
        String[] carNames = inputView.inputCarNames().split(CAR_NAME_DELIMITER);
        int raceRound = inputView.inputRaceRound();

        RaceResult raceResult = racingCarService.race(List.of(carNames), raceRound, new RandomMovementStrategy());

        outputView.printRaceResult(raceResult);
    }
}
