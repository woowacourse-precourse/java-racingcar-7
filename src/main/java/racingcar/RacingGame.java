package racingcar;

import racingcar.iohandler.InputHandler;
import racingcar.iohandler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {

        outputHandler.showCarNamesInputComments();
        List<Car> cars = inputHandler.getCarNamesFromUser();

        outputHandler.showMoveCountInputComments();
        int moveCount = inputHandler.getMoveCountFromUser();

        showCarProceedScores(moveCount, cars);

        List<String> winners = calculateWinners(cars);
        outputHandler.showWinners(winners);
    }

    private void showCarProceedScores(int moveCount, List<Car> cars) {
        outputHandler.showCarProceedComments();
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                int proceedScore = car.proceed();
                outputHandler.showCarProceedScore(car, proceedScore);
            }
            outputHandler.showNewLine();
        }
    }

    private List<String> calculateWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            int score = car.getScore();
            if (score > max) {
                max = score;
                winners.clear();
                winners.add(car.getCarName());
            } else if (score == max) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
