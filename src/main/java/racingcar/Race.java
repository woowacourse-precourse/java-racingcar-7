package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private Integer tries = 0;

    public List<String> run() {
        for (int i = 0; i < this.tries; i++) {
            moveForward(cars);
            System.out.println();
        }

        int maxDistance = cars.stream().max(Comparator.comparingInt(Car::getDistance)).orElseThrow().getDistance();
        return cars.stream().filter(e -> e.getDistance() == maxDistance).map(Car::getCarName).toList();
    }

    public void setCars(String userInput) {
        List<String> carNameList = List.of(userInput.split(","));
        for (String carName : carNameList) {
            validate(carName);
            cars.add(new Car(carName));
        }
    }

    public void setTries(String tries) {
        try {
            this.tries = Integer.valueOf(tries);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("tries should be a number");
        }
    }

    private void validate(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("car length should be less than or equal to 5");
        }
        if (this.cars.stream().map(Car::getCarName).toList().contains(car)) {
            throw new IllegalArgumentException("car already exists");
        }
    }

    private void moveForward(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getDistance()));
        }
    }
}
