package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameFactory {
    public RacingGame createGame(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .filter(name -> !name.isEmpty())  // 빈 문자열 필터링
                .map(Car::new)
                .collect(Collectors.toList());
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("유효한 자동차 이름이 없습니다.");
        }
        return new RacingGame(cars);
    }
}
