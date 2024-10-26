package util;

import repository.CarRepository;

public class Race {

    public static void startRacingAllCars() {
        for (Car car : CarRepository.cars) {
            car.startRacing();
        }
    }

}
