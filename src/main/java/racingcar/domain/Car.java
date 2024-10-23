package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Car(
    String name,
    int distance
) {

    public Car updateDistance(Car car, boolean followingNumberRule) {
        if (followingNumberRule) {
            return new Car(car.name, car.distance + 1);
        }
        return car;
    }

    public String makingCarDistanceResult() {
        return name + " : " + "-".repeat(Math.max(0, distance));
    }

    public static List<Car> makeCars(List<String> carNames) {
        List<Car> allCar = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
            }
            allCar.add(new Car(name, 0));
        }
        return allCar;
    }
}
