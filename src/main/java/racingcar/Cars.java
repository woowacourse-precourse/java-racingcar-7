package racingcar;

import java.util.ArrayList;
import java.util.List;

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

    public void printRacingProgress() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}