package racingcar.feature;

import racingcar.obj.Car;

import java.util.List;

public class Race {

    public void startRace(List<Car> cars, int time) {
        for (int i = 0; i < time; i++) {
            for (Car car : cars) {
                car.startRace();
            }
            System.out.println();
        }
    }


}
