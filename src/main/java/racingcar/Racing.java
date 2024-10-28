package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars = new ArrayList<>();

    public void setupCars(String input) {
        List<String> inputList = Validator.validateInput(input);
        inputList.forEach(name -> cars.add(new Car(name.trim())));
    }

    public void performRaceRound() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM) >= MOVE_THRESHOLD) {
                car.moveForward();
            }
        });
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinners() {
        int highestPosition = getHighestPosition();
        if (highestPosition == 0) {
            return "전진한 자동차가 없습니다.";
        }
        return getWinnerNames(highestPosition);
    }

    private int getHighestPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    private String getWinnerNames(int highestPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}

