package racingcar.car;

import static racingcar.car.ErrorMessage.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.car.ErrorMessage.ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE;
import static racingcar.car.ErrorMessage.NAME_COUNT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        for (Car car : cars) {
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
