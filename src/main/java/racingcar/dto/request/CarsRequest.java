package racingcar.dto.request;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Position;

import java.util.Arrays;
import java.util.List;

public record CarsRequest(
        String carNames
) {
    public static Cars from(String carName) {
        List<Car> list = parseToName(carName).stream()
                .map(name -> new Car(name, new Position()))
                .toList();
        return new Cars(list);

    }

    private static List<CarName> parseToName(String carNames) {
        //TODO: parse메서드 위치 고민 및 콤마 상수 처리
        return Arrays.stream(carNames.split(","))
                .map(String::strip)
                .filter(name -> !name.isBlank())
                .map(CarName::new)
                .toList();
    }
}
