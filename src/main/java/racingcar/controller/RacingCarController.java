package racingcar.controller;

//import racingcar.service.RacingCarService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.service.InputValidator;
import racingcar.service.RacingCarService;
import racingcar.service.StringHandler;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final InputValidator inputValidator;
    private final StringHandler stringHandler;
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarView racingCarView, InputValidator inputValidator, StringHandler stringHandler,
                               RacingCarService racingCarService) {
        this.racingCarView = racingCarView;
        this.inputValidator = inputValidator;
        this.stringHandler = stringHandler;
        this.racingCarService = racingCarService;
    }

    public void start() {

        // 경주할 자동차 이름 입력
        String carNameInput = racingCarView.getCarNameInput();
        String[] carNames = stringHandler.split(carNameInput);
        inputValidator.validateCarNames(carNames);

        // 시도할 횟수 입력
        String tryCountInput = racingCarView.getTryCount();
        int tryCount = stringHandler.StringToInt(tryCountInput);
        inputValidator.validateTryCount(tryCount);

        // 레이싱할 자동차 리스트 생성
        List<Car> cars = Arrays.stream(carNames)
                .map(carName -> Car.of(carName))
                .collect(Collectors.toList());

        // 게임 진행
        List<String> winnerList = racingCarService.startRacingGame(cars, tryCount);

        // 게임 결과 출력
        String result = stringHandler.join(winnerList);
        racingCarView.printResult(result);
    }
}
