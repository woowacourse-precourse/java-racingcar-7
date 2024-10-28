package racingcar.service;


import racingcar.exception.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameService {
    private static final String ATTEMPTS_REGEX = "^[1-9]\\d*$"; // 양의 정수 판별을 위한 정규식

    private final Cars cars;
    private final int attempts;
    public int getAttempts() {
        return attempts;
    }

    public GameService(Cars cars, String attemptsInput) {
        this.cars = cars;
        this.attempts = validateAttempts(attemptsInput);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private int validateAttempts(String attemptsInput) {
        checkIfEmpty(attemptsInput);
        checkIfValidNumber(attemptsInput);
        return Integer.parseInt(attemptsInput);
    }

    private void checkIfEmpty(String attemptsInput) {
        if (attemptsInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ATTEMPTS.getMessage());
        }
    }

    private void checkIfValidNumber(String attemptsInput) {
        if (!Pattern.matches(ATTEMPTS_REGEX, attemptsInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPTS.getMessage());
        }
    }

}