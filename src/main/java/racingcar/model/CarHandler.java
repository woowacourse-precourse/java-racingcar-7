package racingcar.model;

import racingcar.validate.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarHandler {

    private static final String COMMA = ",";
    private static final String HYPHEN = "-";

    private final List<Car> cars = new ArrayList<>();
    private final Validation validation = new Validation();

    public void createCar(String input) {
        String[] carNames = input.split(COMMA);
        for (String car : carNames) {
            validation.isInvalidInput(car);
            validation.isInvalidNameLength(car);
            this.cars.add(new Car(car));
        }
    }

    public void executeRounds(int num) {
        for (int i = 0; i < num; i++) {
            proceedCar();
        }
    }

    private void proceedCar() {
        for (Car car : cars) {
            car.moveCar();
            int carMoveCount = car.getMoveCount();
            System.out.println(car.getName() + " : " + HYPHEN.repeat(carMoveCount));
        }
        System.out.println();
    }

    public List<Car> getWinnerList() {
        int winnerMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.isSameMoveCount(winnerMoveCount))
                .collect(Collectors.toList());
    }

}
