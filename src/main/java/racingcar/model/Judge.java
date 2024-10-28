package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    public Boolean judgeGoOrStop(Integer randomNumber) {
        return randomNumber >= 4;
    }

    public List<String> getWinners(List<Car> carList) {
        Long maxPosition = carList.stream()
                .mapToLong(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
