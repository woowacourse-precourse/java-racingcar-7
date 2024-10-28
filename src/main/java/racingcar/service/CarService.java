package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.util.ErrorMessage;

public class CarService {
    private static final String DELIMITER = ",";
    public String[] getCarsByDelimiter(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }
        String[] cars = carNames.split(DELIMITER);
        if (cars.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_DELIMITER_STRING.getMessage());
        }
        for (String name : cars) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.BLANK_NAME.getMessage());
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
            }
        }
        return cars;
    }

    public int getNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }
        if (number.charAt(0) == '-') {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
        try {
            int data = Integer.parseInt(number);
            if (data <= 0) {
                throw new IllegalArgumentException(ErrorMessage.ZERO_OR_OVERFLOW.getMessage());
            }
            return data;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    public String getWinner(List<Car> cars) {
        int winnerPosition = cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition().length() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public List<Car> getCarsByCarNames(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
