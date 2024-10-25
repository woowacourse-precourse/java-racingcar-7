package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class Service {
    private static final String COMMA = ",";

    public ArrayList<String> splitCarNames(final String carNames) {
        return new ArrayList<>(Arrays.stream(carNames.split(COMMA)).toList());
    }

    public void playRound(final Race race) {
        race.getCarArrayList().stream()
                .filter(Car::isMove)
                .forEach(Car::plusLocation);
    }

    public int getMaxDistance(final List<Integer> distanceList) {
        return distanceList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCarListWithMaxDistance(final List<Car> carArrayList, int maxDistance) {
        return carArrayList.stream()
                .filter(car -> car.getLocation() == maxDistance)
                .collect(Collectors.toList());
    }
}
