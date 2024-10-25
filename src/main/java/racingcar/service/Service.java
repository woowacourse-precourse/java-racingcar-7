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
        race.getCarList().stream()
                .filter(Car::isMove)
                .forEach(Car::plusLocation);
    }

    public int getMaxDistance(final List<Integer> distanceList) {
        return distanceList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCarListWithMaxDistance(final List<Car> carList, int maxDistance) {
        return carList.stream()
                .filter(car -> car.getLocation() == maxDistance)
                .collect(Collectors.toList());
    }

    public List<Car> registerCar(final List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        carNames.forEach(carName -> carList.add(new Car(carName)));
        return carList;
    }

    public Race registerRace(final List<Car> carList, final int attemptCount) {
        return new Race(carList, attemptCount);
    }
}
