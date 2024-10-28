package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceTime;
import racingcar.view.RaceInput;
import racingcar.view.RaceOutput;

public class CarRacing {
    private static final String RACING_START_MESSAGE = "실행 결과";

    private CarRacing() {
    }

    public static void start() {
        Cars cars = new Cars(RaceInput.getNames());
        RaceTime raceTime = new RaceTime(RaceInput.getRaceTime());

        RaceOutput.println();
        RaceOutput.println(RACING_START_MESSAGE);
        while (raceTime.isNotOver()) {
            cars.move();
            RaceOutput.printProgress(cars);
            RaceOutput.println();
        }

        RaceOutput.printWinner(cars);
    }
}
