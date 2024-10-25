package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String NAME_COUNT_ERROR_MESSAGE = "이름을 2개 이상 입력해야 합니다.";
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복된 이름을 입력하면 안됩니다.";
    private static final String EMPTY_STRING_NAME_ERROR_MESSAGE = "빈 이름을 입력할 수 없습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 5글자 이하만 가능합니다.";
    private static final String ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE = "랜덤 넘버의 갯수와 자동차의 갯수는 동일해야 합니다.";

    private static final String EMPTY_STRING = "";
    private static final int MAX_LENGTH_OF_NAME = 5;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNameCount(names);
        validateDuplicatedNames(names);
        validateEmptyStringName(names);
        validateNameLength(names);
        cars = initializeCarList(names);
    }

    public int carCount() {
        return cars.size();
    }

    public void attemptMoveAllCars() {
        for (Car car : cars) {
            car.attemptMove();
            car.showStatus();
        }
    }

    public void attemptMoveAllCars(List<Integer> randomNumbers) {
        validateRandomNumberCount(randomNumbers);

        int index = 0;
        for (Car car : cars) {
            int randomNumber = randomNumbers.get(index);
            car.attemptMove(randomNumber);
            car.showStatus();
            index++;
        }
    }

    private void validateRandomNumberCount(List<Integer> randomNumbers) {
        if (randomNumbers.size() != cars.size()) {
            throw new IllegalArgumentException(ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE);
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        int winnerMoveCount = getWinnerMoveCount();

        for(Car car : cars) {
            if (car.isWinner(winnerMoveCount)) {
                String winnerName = car.getName();
                winnerNames.add(winnerName);
            }
        }
        return winnerNames;
    }

    private void validateNameCount(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(NAME_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNames(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE);
        }
    }

    private void validateEmptyStringName(List<String> names) {
        if (names.contains(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_STRING_NAME_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private List<Car> initializeCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private int getWinnerMoveCount() {
        sortCarsDescByMoveCount();
        Car winner = cars.getFirst();
        return winner.getMoveCount();
    }

    private void sortCarsDescByMoveCount() {
        Collections.sort(cars);
    }
}
