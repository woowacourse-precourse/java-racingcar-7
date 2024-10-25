package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> names = InputCar.readCarNames();
            int tryCount = InputCar.readTryCount();

            Cars cars = new Cars(names);

            OutputCar.printStart();
            playGame(cars, tryCount);
            announceWinner(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            OutputCar.printRoundResult(cars.getCars());
        }
    }

    private static void announceWinner(Cars cars) {
        List<String> winners = cars.getWinners();
        OutputCar.printWinners(winners);
    }
}