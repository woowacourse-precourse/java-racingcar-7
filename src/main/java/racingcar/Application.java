package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        InputParser inputParser = new InputParser();
        GameController gameController = new GameController();

        String inputCarName = inputHandler.inputCarName();
        List<Car> car = inputParser.parseCarName(inputCarName);

        String inputAttemptNumber = inputHandler.inputAttemptNumber();
        int attemptNumber = inputParser.parseAttemptNumber(inputAttemptNumber);

        System.out.println("실행 결과");
        gameController.moveCars(car, attemptNumber);
    }
}
