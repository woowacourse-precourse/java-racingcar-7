package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.RandomNumberGenerator;

public record Cars(
    List<Car> allCar
) {

    public Cars eachGame() {
        List<Car> result = new ArrayList<>();
        for (Car car : allCar) {
            Car resultCar = car.updateDistance(car, RandomNumberGenerator.isFollowNumberRule());
            result.add(resultCar); //네이밍
        }
        return new Cars(result);
    }

    public static Cars makeOriginCars(List<String> carNames) {
        ArrayList<Car> allCar = new ArrayList<>();
        for (String name : carNames) {
            allCar.add(new Car(name, 0));
        }
        return new Cars(allCar);
    }

    public String makingEachGameResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : allCar) {
            result.append(car.makingCarDistanceResult());
            result.append("\n");
        }
        return result.toString();
    }
}
