package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Cars(
        List<Car> allCar
) {

    public static Cars makeOriginCars(List<String> carNames) {
        List<Car> allCar = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
            }
            allCar.add(new Car(name, 0));
        }
        return new Cars(allCar);
    }

    public int findLongestDistance() {
        int longestDistance = 0;
        for (Car car : allCar) {
            if (car.distance() > longestDistance) {
                longestDistance = car.distance();
            }
        }
        return longestDistance;
    }

    public String makeResultOutput() {
        StringBuilder resultString = new StringBuilder();
        for (Car car : allCar) {
            resultString.append(car.makingCarDistanceResult());
            resultString.append('\n');
        }
        return resultString.toString();
    }
}
