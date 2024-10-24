package racingcar.controller;

import racingcar.model.entity.Cars;
import racingcar.model.dto.RacingResult;
import racingcar.model.entity.CarNames;
import racingcar.model.entity.RacingChance;
import racingcar.service.RacingService;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 전체적인 진행을 맡는 클래스
 * View와 메시지를 주고 받는다.
 */
public class RacingController {

    private final InputView inputView;

    private final OutputView outputView;

    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView,
                            RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        CarNames carNames = CarNames.getAfterValidateForm(inputView.getCarNames());
        RacingChance racingChance =
                RacingChance.getAfterValidateForm(inputView.getChanceToMove());
        Cars cars = Cars.getOfNamesAndStrategy(carNames, new RandomMoveStrategy());

        racingService.raceOfCarsAndChance(cars, racingChance);
        RacingResult result = racingService.getResult();
        outputView.printRacingResult(result);
    }

}
