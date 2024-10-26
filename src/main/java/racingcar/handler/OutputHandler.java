package racingcar.handler;

import racingcar.model.Car;
import racingcar.model.Race;

public class OutputHandler {

    public void printRoundResult(Race race) {
        race.getCars().forEach(this::carStatusPrintFormat);
        System.out.println();
    }

    private void carStatusPrintFormat(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }

}
