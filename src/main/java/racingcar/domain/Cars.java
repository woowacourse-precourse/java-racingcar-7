package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String invalidCarNames) {
        List<String> splitCarNames = Arrays.stream(invalidCarNames.split(",")).toList();
        validateCarNames(splitCarNames);

        cars = splitCarNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateCarNames(List<String> splitCarNames) {
        if (splitCarNames.size() < 2) {
            throw new IllegalArgumentException("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
        }

        if (splitCarNames.stream().distinct().count() != splitCarNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }

    public void moveAll() {
        cars.forEach(Car::moveForward);
    }

    public String getCurrentRoundResult() {
        StringBuilder builder = new StringBuilder();
        cars.forEach(builder::append);

        return builder.toString();
    }

    public String findWinnerCarNames() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
