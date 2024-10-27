package racingcar.io;

import racingcar.race.racer.car.Car;

import java.util.List;

public class CarOutputHandler extends OutputHandler<Car> {

    @Override
    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }
}
