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

    public List<Car> getCars() {
        return cars;
    }

    public void validateDuplicateName(List<Car> cars) {

        for (Car car : cars) {
            Name name = car.name;
            if (nameSet.contains(name.getName())) {
                throw new IllegalArgumentException();
            }
            nameSet.add(name.getName());
        }
    }

    public void moveForward() {

        for (Car car : cars) {
            car.moveForward();
        }
    }

    public void printRacingProgress() {

        for (Car car : cars) {
            System.out.print(car.name.getName() + " : ");

            for (int j = 0; j < car.position; j++) {
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
            if (car.position > maxPosition) {
                maxPosition = car.position;
            }
        }

        for (Car car : cars) {
            if (car.position == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
