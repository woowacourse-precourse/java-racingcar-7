package util;

import repository.CarRepository;

public class Race {

    public static void startRacing() {
        for (Car car : CarRepository.cars) {
            car.startRacing();
        }
    }

}
