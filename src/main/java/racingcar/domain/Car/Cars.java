package racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.Output.OutputHandler;

public class Cars {
    private final List<Car> cars;

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
            if (car.getName().equals(carName)) {
                throw new IllegalArgumentException();
            }
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
        List<Car> winners = new ArrayList<>();
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}