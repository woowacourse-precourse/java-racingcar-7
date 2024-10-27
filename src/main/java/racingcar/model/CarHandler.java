package racingcar.model;

import racingcar.validate.Validation;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarHandler {

    private static final String COMMA = ",";

    private final List<Car> cars = new ArrayList<>();
    private final Validation validation = new Validation();

    public void createCar(String input) {
        Set<String> distinctCarsName = new HashSet<>();
        String[] carNames = input.split(COMMA);

        for (String car : carNames) {
            car = car.trim();
            validation.isInvalidInput(car);
            validation.isInvalidNameLength(car);
            validation.isDuplicateCarName(car, distinctCarsName);

            this.cars.add(new Car(car));
        }
    }

    public void executeRounds(int num) {
        OutputMessage.resultMessage();
        for (int i = 0; i < num; i++) {
            proceedCar();
        }
    }

    private void proceedCar() {
        for (Car car : cars) {
            car.moveCar();
            int carMoveCount = car.getMoveCount();
            OutputMessage.resultHyphenMessage(car.getName(), carMoveCount);
        }
        System.out.println();
    }

    public String resultWinnerList() { // 이동된 메서드
        return getWinnerList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));
    }

    private List<Car> getWinnerList() {
        return cars.stream()
                .filter(car -> car.isSameMoveCount(getWinnerMoveCount()))
                .collect(Collectors.toList());
    }

    private int getWinnerMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

}
