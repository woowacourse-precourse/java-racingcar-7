package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        InputParser inputParser = new InputParser();

        GameConfiguration gameConfiguration = new GameConfiguration(inputHandler, inputParser);

        // 자동차 리스트와 Result 객체 생성
        List<Car> cars = new ArrayList<>();
        Result result = new Result();

        // RacingGame 객체 생성 및 실행
        RacingGame racingGame = new RacingGame(gameConfiguration, cars, result);
        racingGame.run();

    }
}
