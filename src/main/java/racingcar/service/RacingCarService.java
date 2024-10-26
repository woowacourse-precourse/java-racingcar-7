package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Car;
import racingcar.enums.ErrorMessage;

public class RacingCarService {

    public List<Car> makeCarList(String inputString) {
        List<Car> cars = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<String> findWinners(List<Car> cars, int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        return winners;
    }
}
