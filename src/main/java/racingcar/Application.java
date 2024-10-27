package racingcar;

import java.util.List;
import racingcar.car.strategy.MoveStrategy;
import racingcar.car.strategy.RandomMoveStrategy;
import racingcar.game.*;
import racingcar.car.*;
import racingcar.util.*;
import racingcar.view.*;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringParser stringParser = new StringParser();
        InputHandler inputHandler = new InputHandler(validator, stringParser);

        // 자동차 이름과 경주 횟수 입력
        List<String> carNames = inputHandler.getInputAboutCars();
        int rounds = inputHandler.getInputAboutRound();

        // 전략 주입
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MoveStrategy moveStrategy = new RandomMoveStrategy(numberGenerator);

        // 자동차 객체 목록 생성
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createCars(carNames, moveStrategy);

        // 경주 게임을 생성하고 시작
        RacingGame racingGame = new RacingGame(cars, rounds);
        RacingGameController racingGameController = new RacingGameController(racingGame, new OutputHandler());

        racingGameController.startGame();
    }
}
