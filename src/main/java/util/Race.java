package util;

import repository.CarRepository;

public class Race {

    public static void startRacing(int repeatCount) {
        for (Car car : CarRepository.cars) {
            car.startRacing(repeatCount);
        }
    }


}
