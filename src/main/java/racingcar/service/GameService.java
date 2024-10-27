package racingcar.service;

import static racingcar.validation.Validation.validateName;
import static racingcar.validation.Validation.validateSameName;

import java.util.ArrayList;
import racingcar.domain.Car;

public class GameService {

    public static ArrayList<String> splitCarName(String carName) {
        ArrayList<String> carNameArray = new ArrayList<>();
        for (String name : carName.split(",", -1)) {
            validateName(name);
            validateSameName(carNameArray, name);
            carNameArray.add(name);
        }
        return carNameArray;
    }

    public static Car[] registerCarParticipants(ArrayList<String> carNameArray) {
        Car[] cars = new Car[carNameArray.size()];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNameArray.get(i), 0);
        }
        return cars;
    }
}
