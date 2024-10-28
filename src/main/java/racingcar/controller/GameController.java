package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.factory.CarFactory;
import racingcar.view.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 자동차 이름 입력
        String inputName = inputView.requestCarNames();
        List<String> carNames = InputParser.parseCarNames(inputName);

        // 진행할 라운드 수 입력
        String inputRound = inputView.requestMaxRound();
        BigInteger round =  InputParser.parseMaxRound(inputRound);

        // 입력받은 자동차 이름 수 만큼 자동차 생성
        List<Car> cars = CarFactory.createCars(carNames);

        // 자동차 경주 시작
        RacingGame.play(cars, round);
    }
}
