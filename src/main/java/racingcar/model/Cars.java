package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.ErrorMessages;
import racingcar.util.RandomUtil;

public class Cars {
    private static final String DELIMITER_COMMA = ",";
    private static final int MIN_LIST_SIZE = 2;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> carList;

    public Cars(String carNames) {
        List<Car> tempCarList = convertCarNamesToList(carNames).stream()
                .map(Car::new)
                .toList();
        validateListSize(tempCarList);
        validateNoDuplicateNames(tempCarList);
        this.carList = tempCarList;
    }

    private List<String> convertCarNamesToList(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER_COMMA));
    }

    private void validateListSize(List<Car> carList) {
        if (carList.size() < MIN_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_LIST_SIZE);
        }
    }

    private void validateNoDuplicateNames(List<Car> carList) {
        long distinctCount = carList.stream()
                .distinct()
                .count();
        if (carList.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NAME);
        }
    }

    public void tryMoveAll() {
        carList.forEach(car -> {
            int randomNumber = RandomUtil.generateRandomNumber();
            if (isMovable(randomNumber)) {
                car.move();
            }
        });
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public List<String> getRaceWinner() {
        int max = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .toList();
    }

    public int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.BLANK_INPUT));
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"))
                + "\n";
    }
}
