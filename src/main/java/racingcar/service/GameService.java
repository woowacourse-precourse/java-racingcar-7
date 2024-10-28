package racingcar.service;

import static racingcar.validation.ValidationName.validateName;
import static racingcar.validation.ValidationName.validateSameName;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.view.Output;

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

    public static void gameWinners(Car[] cars, int max) {
        ArrayList<String> gameWinners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == max) {
                gameWinners.add(car.getCarName());
            }
        }
        String winners = String.join(", ", gameWinners);
        Output.gameWinners(winners);
    }
}
