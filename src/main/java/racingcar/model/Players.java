package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Players {
    private final List<Car> players = new ArrayList<>();

    public void registerAll(List<String> names) {
        validateNamesSize(names);

        names.forEach(name -> {
            Car car = Car.from(name);
            validate(car);
            players.add(car);
        });
    }

    public List<Car> getPlayers() {
        return players;
    }

    public List<Car> getWinner() {
        Integer winnerPosition = players.stream().map(Car::getCurrentLocation)
                .max(Comparator.comparing(x -> x))
                .orElseThrow(IllegalArgumentException::new);

        return players.stream().filter(car -> car.getCurrentLocation() == winnerPosition).toList();
    }

    private void validate(Car car) {
        validateCarsSize();
        validateDuplicate(car);
    }

    private void validateNamesSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최소 2개입니다.");
        }
    }

    private void validateDuplicate(Car carForRegistration) {
        boolean isDuplicate = players.stream().anyMatch(carForRegistration::equals);
        if (isDuplicate) {
            throw new IllegalArgumentException("게임 내 중복된 이름이 존재합니다.");
        }
    }

    private void validateCarsSize() {
        if (players.size() >= 10) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최대 10개입니다.");
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + players +
                '}';
    }
}
