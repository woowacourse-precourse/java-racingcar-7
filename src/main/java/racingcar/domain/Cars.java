package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATED_NAME = "각 차는 한번만 입력해야 합니다";
    private static final String OUT_OF_RANGE_NAME = "차는 다섯글자 이하이어야 합니다";

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String DELIMITER = ":";
    private static final String SPLITOR = ",";
    private static final Integer HIGHEST_NAME_LENGTH = 5;

    private List<Car> cars;

    public Cars(String carsInput) {
        validateDuplicatedName(carsInput);
        validateOutOfRangeName(carsInput);

        this.cars = makeCarList(carsInput);

    }

    private List<Car> makeCarList(String carsInput) {
        List<Car> carList = Arrays.stream(carsInput.split(SPLITOR))
                .map(carName -> new Car(carName, ""))
                .toList();

        return carList;
    }


    private static void validateDuplicatedName(String carsInput) {
        long before = carsInput.split(SPLITOR).length;

        long after = Arrays.stream(carsInput.split(SPLITOR)).
                distinct().
                count();

        if (before != after) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
    }

    private void validateOutOfRangeName(String carsInput) {
        boolean result = Arrays.stream(carsInput.split(SPLITOR))
                .anyMatch((car) -> car.length() > HIGHEST_NAME_LENGTH);

        if (result) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NAME);
        }
    }

    public void race() {
        cars.stream()
                .forEach(car -> car.act(RandomNumberGenerator.createRandomNumber()));
    }

    public void printState() {
        cars.stream()
                .forEach(car -> {
                    System.out.println(car.name + SPACE + DELIMITER + SPACE + car.state);
                });
        System.out.println(BLANK);
    }

    public String findWinners() {
        int maxDistance = findMaxDistance();

        List<Car> winnerList = filterWinners(maxDistance);

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> filterWinners(int maxDistance) {
        return cars.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();
    }

    private int findMaxDistance() {
        Car winner = cars.stream()
                .max(Comparator.comparing(car -> car.getDistance()))
                .orElseThrow(NullPointerException::new);

        return winner.getDistance();
    }
}
