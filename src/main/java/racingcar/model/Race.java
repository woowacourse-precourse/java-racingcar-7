package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.InputValidation;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private List<Car> cars;
    private List<String> winner = new ArrayList<>();
    private int count;
    private int maxPosition;

    public Race(String inputtedName, String count) {
        String[] carNames = inputtedName.split(DELIMITER, -1);
        cars = Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        InputValidation.validateDelimiter(inputtedName);
        InputValidation.validateNameLength(cars);

        InputValidation.validateIntRange(count);
        InputValidation.validateNumberFormat(count);
        InputValidation.validatePositiveNumber(count);
        this.count = Integer.parseInt(count);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinner() {
        return winner;
    }

    public int getCount() {
        return count;
    }

    public void moveCars() {
        cars.stream()
                .forEach(car -> {
                    int point = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
                    car.moveBasedOnPoint(point);
                });
    }

    public void findMaxPosition() {
        Optional<Car> maxCar = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition));
        maxPosition = maxCar.get().getPosition();
    }

    public void findWinner() {
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(car -> winner.add(car.getName()));
    }
}
