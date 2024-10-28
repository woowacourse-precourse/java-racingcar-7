package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.service.RacingService;
import racingcar.util.parser.InputParser;
import racingcar.validator.ValidatorFacade;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final RacingService racingService;
    private final ValidatorFacade validatorFacade;
    private final InputParser inputParser;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController(RacingService racingService, ValidatorFacade validatorFacade,
                         InputParser inputParser) {
        this.racingService = racingService;
        this.validatorFacade = validatorFacade;
        this.inputParser = inputParser;
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void play() {
        String carNamesInput = inputView.getCarNames();

        // 입력 파싱 및 개별 이름 유효성 검사
        CarNames names = inputParser.parse(carNamesInput);
        for (String carName : names.getNames()) {
            validatorFacade.validateCarNames(carName); // 개별 이름에 대한 유효성 검사
        }

        validatorFacade.validateCarCount(names);

        String countInput = inputView.getCount();

        // 라운드 수 유효성 검사
        validatorFacade.validateRoundCount(countInput);
        int count = Integer.parseInt(countInput);

        // 유효성 검사를 통과한 경우 게임 시작
        Cars cars = racingService.initializeCars(names);

        outputView.showResultMessage();
        // 각 라운드 결과 표시
        for (int i = 0; i < count; i++) {
            racingService.playRound(cars); // 매 라운드 진행
            outputView.showRoundResult(cars); // 매 라운드 결과 표시
        }
        List<Car> winners = cars.getWinners();
        outputView.showWinners(winners);
    }
}
