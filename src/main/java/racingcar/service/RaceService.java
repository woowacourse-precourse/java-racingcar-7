package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RandomNumber;
import racingcar.util.Validator;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<String> decisionWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getWinnerPosition(List<Car> cars) {
        Car winner = Collections.max(cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String name : carNames) {
            Cars.add(new Car(name));
        }
        return Cars;
    }
}
