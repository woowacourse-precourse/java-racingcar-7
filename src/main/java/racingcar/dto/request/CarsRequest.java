package racingcar.dto.request;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.CarPosition;

import java.util.Arrays;
import java.util.List;

public record CarsRequest(
        String carNames
) {
    public Cars toCars() {
        List<Car> cars = parseToName(carNames).stream()
                .map(name -> new Car(name, new CarPosition()))
                .toList();
        return new Cars(cars);

    }

    private List<CarName> parseToName(String carNames) {
        //TODO: parse메서드 위치 고민 및 콤마 상수 처리
        return Arrays.stream(carNames.split(","))
                .map(String::strip)
                .filter(name -> !name.isBlank())
                .map(CarName::new)
                .toList();
    }
}
