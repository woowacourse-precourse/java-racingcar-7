package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;
    private final Set<String> nameSet;

    public Cars(List<Car> cars) {
        this.nameSet = new HashSet<>();
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public void validateDuplicateName(List<Car> cars) {

        for (Car car : cars) {
            String name = car.getName();
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException();
            }
            nameSet.add(name);
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

        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
