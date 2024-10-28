package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.service.RacingService;
import racingcar.util.InputSplitter;
import racingcar.validator.ValidatorFacade;
import racingcar.view.ViewFacade;

public class CarController {
    private final RacingService racingService;
    private final ValidatorFacade validatorFacade;
    private final ViewFacade viewFacade;

    public CarController(RacingService racingService, ValidatorFacade validatorFacade, ViewFacade viewFacade) {
        this.racingService = racingService;
        this.validatorFacade = validatorFacade;
        this.viewFacade = viewFacade;
    }

    public void play() {
        String carNamesInput = viewFacade.getCarNames();

        // 입력 파싱 및 개별 이름 유효성 검사
        CarNames names = InputSplitter.split(carNamesInput);
        for (String carName : names.getNames()) {
            validatorFacade.validateCarNames(carName); // 개별 이름에 대한 유효성 검사
        }

        validatorFacade.validateCarCount(names);

        String countInput = viewFacade.getCount();

        // 라운드 수 유효성 검사
        validatorFacade.validateRoundCount(countInput);
        int count = Integer.parseInt(countInput);

        // 유효성 검사를 통과한 경우 게임 시작
        Cars cars = racingService.initializeCars(names);

        viewFacade.showResultMessage();
        // 각 라운드 결과 표시
        for (int i = 0; i < count; i++) {
            racingService.playRound(cars); // 매 라운드 진행
            viewFacade.showRoundResult(cars); // 매 라운드 결과 표시
        }
        List<Car> winners = cars.getWinners();
        viewFacade.showWinners(winners);
    }
}
