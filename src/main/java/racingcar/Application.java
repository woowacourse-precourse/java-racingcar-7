package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        InputParser inputParser = new InputParser();
        GameController gameController = new GameController();

        String inputCarName = inputHandler.inputCarName();
        List<Car> car = inputParser.parseCarName(inputCarName);

        if (car.size() > 1) {
            String inputAttemptNumber = inputHandler.inputAttemptNumber();
            int attemptNumber = inputParser.parseAttemptNumber(inputAttemptNumber);

            System.out.println("\n실행 결과");
            gameController.moveCars(car, attemptNumber);
        }

        gameController.maxCarName(car);
    }
}
