package racingcar;

import racingcar.iohandler.InputHandler;
import racingcar.iohandler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Car.createCar;

public class RacingGame {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {

        outputHandler.showCarNamesInputComments();
        String[] carNames = inputHandler.getCarNamesFromUser();
        List<Car> cars = createCarsFrom(carNames);

        outputHandler.showMoveCountInputComments();
        int moveCount = inputHandler.getMoveCountFromUser();

        showCarProceedScores(moveCount, cars);

        List<String> winners = calculateWinners(cars);
        outputHandler.showWinners(winners);
    }

    private static List<Car> createCarsFrom(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = createCar(name);
            cars.add(car);
        }
        return cars;
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
