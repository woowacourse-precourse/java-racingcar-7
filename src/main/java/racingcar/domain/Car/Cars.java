package racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import racingcar.exceptions.DuplicateNameException;
import racingcar.io.Output.OutputHandler;

public class Cars {
    private final List<Car> cars;

    List<Car> winners = new ArrayList<>();


    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String[] carNameList) {
        for (String carName : carNameList) {
            validateDuplicateName(carName);
            Car car = new Car(new Name(carName));
            cars.add(car);
        }
    }

    private void validateDuplicateName(String carName) {
        for (Car car : cars) {
            isDuplicateName(car, carName);
        }
    }

    private void isDuplicateName(Car car, String carName) {
        if (car.getName().equals(carName)) {
            throw new DuplicateNameException("중복된 이름이 존재합니다.");
        }
    }

    public void moveForward() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public void printRacingProgress(OutputHandler outputHandler) {
        for (Car car : cars) {
            outputHandler.printCarProgress(car.getName(), car.getPosition());
        }
        outputHandler.printNewLine();
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();

        for (Car car : cars) {
            addWinnerIfEqualMaxPosition(car, maxPosition);
        }
        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void addWinnerIfEqualMaxPosition(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}