package racingcar.vo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarsPositionSnapshot {
    private final Map<Name, Position> value;

    private CarsPositionSnapshot(Map<Name, Position> value) {
        this.value = value;
    }

    public static CarsPositionSnapshot from(List<Car> cars) {
        Map<Name, Position> positions = cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition,
                        (existing, replacement) -> replacement,
                        LinkedHashMap::new // 입력 순서 보장을 위해 LinkedHashMap 사용
                ));

        return new CarsPositionSnapshot(positions);
    }

    public Map<Name, Position> getValue() {
        return value;
    }
}
