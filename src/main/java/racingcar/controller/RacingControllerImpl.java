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
 * InputView로부터 자동차 이름과 주행 시도 횟수 문자열을 건네 받아서
 * 객체 생성 후 Cars 객체를 생성한다. Service에게 Cars객체와 RacingChance를
 * 넘겨주고 결과 값을 요청하며 OutputView에 결과를 전달한다.
 */
public class RacingControllerImpl implements RacingController {

    private final InputView inputView;

    private final OutputView outputView;

    private final RacingService racingService;

    public RacingControllerImpl(InputView inputView, OutputView outputView,
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
