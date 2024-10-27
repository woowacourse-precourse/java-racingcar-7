package racingcar.car;

import static racingcar.car.constant.Constants.DELIMITER;
import static racingcar.car.constant.Constants.WINNER_RESULT_MESSAGE;
import static racingcar.car.constant.ErrorMessage.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.car.constant.ErrorMessage.ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE;
import static racingcar.car.constant.ErrorMessage.NAME_COUNT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.io.OutputManager;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNameCount(names);
        validateDuplicatedNames(names);
        cars = initializeCarList(names);
    }

    public int carCount() {
        return cars.size();
    }

    public void attemptMovingAllCars() {
        for (Car car : cars) {
            car.attemptMoving();
        }
    }

    public void attemptMovingAllCars(List<Integer> randomNumbers) {
        validateRandomNumberCount(randomNumbers);

        int index = 0;
        for (Car car : cars) {
            int randomNumber = randomNumbers.get(index);
            car.attemptMoving(randomNumber);
            index++;
        }
    }

    public void showAllCarsStatus() {
        for (Car car : cars) {
            car.showStatus();
        }
    }

    public void showWinner() {
        List<String> winnerNames = getWinnerNames();
        String joinedWinnerName = getJoinedWinnerName(winnerNames);
        printWinner(joinedWinnerName);
    }

    private List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        int winnerMoveCount = getWinnerMoveCount();

        cars.stream()
                .filter(car -> car.isWinner(winnerMoveCount))
                .map(Car::getName)
                .forEach(winnerNames::add);

        return winnerNames;
    }

    private void validateRandomNumberCount(List<Integer> randomNumbers) {
        if (randomNumbers.size() != cars.size()) {
            throw new IllegalArgumentException(ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE);
        }
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

    private List<Car> initializeCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private int getWinnerMoveCount() {
        int maxMoveCount = 0;

        for (Car car : cars) {
            int moveCount = car.getMoveCount();
            maxMoveCount = Math.max(maxMoveCount, moveCount);
        }

        return maxMoveCount;
    }

    private String getJoinedWinnerName(List<String> winnerNames) {
        return String.join(DELIMITER, winnerNames);
    }

    private void printWinner(String joinedWinnerName) {
        OutputManager.printMessage(WINNER_RESULT_MESSAGE + joinedWinnerName);
    }
}
