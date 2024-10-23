package racingcar;

import java.util.List;
import racingcar.controller.RacingGame;
import racingcar.model.*;
import racingcar.util.*;
import racingcar.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringParser stringParser = new StringParser();
        InputHandler inputHandler = new InputHandler(validator, stringParser);

        // 자동차 이름과 경주 횟수 입력
        List<String> carNames = inputHandler.getInputAboutCars();
        int rounds = inputHandler.getInputAboutRound();

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        CarFactory carFactory = new CarFactory();

        // 자동차 객체를 생성하고 전략 주입
        List<Car> cars = carFactory.createCars(carNames, moveStrategy);

        // 경주 게임 시작
        RacingGame racingGame = new RacingGame(cars, rounds);
        racingGame.start();
    }
}
