package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingCarService {

    public List<Car> separateCarNames(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }

    public void updateLocation(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();

            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
