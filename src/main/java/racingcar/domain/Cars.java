package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Utils;

public record Cars(List<Car> carList) {

    public static final String CAR_NAME_DELIMITER = ",";

    public static Cars createCars(String carsString) {
        List<Car> carList = Utils.splitByDelimiter(carsString, CAR_NAME_DELIMITER)
            .stream()
            .map(CarName::new)
            .map(Car::new)
            .toList();
        return new Cars(carList);
    }

    public void moveCars() {
        carList.forEach(car ->
            car.moveForwardIfTrue(Utils.isTrueWithProbability60Percent())
        );
    }

    @Override
    public String toString() {
        return carList.stream()
            .map(Car::toString)
            .collect(Collectors.joining("\n"));
    }
}