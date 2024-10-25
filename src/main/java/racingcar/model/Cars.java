package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawCarsName) {
        this.cars = parseList(rawCarsName);
    }

    private List<Car> parseList(String rawCarsName) {
        String[] parts = rawCarsName.split(",");
        return Arrays.stream(parts)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            if (canForwardCondition()) {
                car.forwardDistance();
            }
        }
    }

    private boolean canForwardCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4; // TODO RandomGenerator 객체로 빼는 게 나을지 생각해보자.
    }

    public void printCarDistance() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private Integer getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public String getWinner() {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == getMaxDistance()) {
                winner.add(car.getName());
            }
        }
        return String.join(",", winner);
    }
}
