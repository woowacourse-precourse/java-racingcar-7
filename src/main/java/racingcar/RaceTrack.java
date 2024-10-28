package racingcar;

import java.util.List;

public class RaceTrack {
    List<Car> carList;

    public RaceTrack(List<Car> carList) {
        this.carList = carList;
    }

    public void run() {
        for(Car car : carList) {
            car.move();
        }
    }

}
