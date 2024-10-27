package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public class InputDecodeService {

    public List<Car> decodeRawCarNames(String rawCarNames) {
        List<String> carNames = List.of(rawCarNames.split(","));
        return carNames.stream().map(Car::new).toList();
    }

    public int decodeRawRoundCount(String rawRoundCount) {
        return Integer.parseInt(rawRoundCount);
    }
}
