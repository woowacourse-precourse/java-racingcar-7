package racingcar;

import static racingcar.OutputView.printCars;
import static racingcar.OutputView.printWinners;

public class Application {
    public static void main(String[] args) {
        String carName = InputView.readCarNamesInput();
        int raceTime = InputView.readRaceTimeInput();

        Cars cars = new Cars(carName);

        printCars(raceTime, cars);
        printWinners(cars);
    }
}

