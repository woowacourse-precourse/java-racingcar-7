package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vehicle.Car;

public class Winner {

    static List<Car> winners = new ArrayList<>();

    public List<Car> getWinners() {
        return winners;
    }

    public List<Car> determineWinners(List<Car> cars) {
        int topForwardCount = cars.stream()
                .mapToInt(car -> car.getForwardCount())
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getForwardCount() == topForwardCount)
                .collect(Collectors.toList());
    }

}
