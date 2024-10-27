package racingcar;

import java.util.ArrayList;

public class Track {
    private final ArrayList<Car> cars;

    public Track(ArrayList<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
