package racingcar.feature;

import racingcar.obj.Car;

public class Race {

    public void startRace(Car[] cars, int time) {
        for (int i = 0; i < time; i++) {
            for (Car car : cars) {
                car.startRace();
            }
            System.out.println();
        }
    }


}
