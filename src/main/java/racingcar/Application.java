package racingcar;

import java.util.List;
import racingcar.controller.RacingGame;
import racingcar.model.*;
import racingcar.util.*;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringParser stringParser = new StringParser();
        InputHandler inputHandler = new InputHandler(validator, stringParser);

        // 자동차 이름과 경주 횟수 입력
        List<String> carNames = inputHandler.getInputAboutCars();
        int rounds = inputHandler.getInputAboutRound();

        // 자동차 객체를 생성하고 전략 주입
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createCars(carNames, moveStrategy);

        // 경주 게임 시작
        OutputHandler outputHandler = new OutputHandler();
        RacingGame racingGame = new RacingGame(outputHandler, cars, rounds);
        racingGame.start();
    }
}
