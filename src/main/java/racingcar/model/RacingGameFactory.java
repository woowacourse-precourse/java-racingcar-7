package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameFactory {
    public RacingGame createGame(String[] carNames) {
        // 필터링 전에 먼저 검증을 해야 함
        if (Arrays.stream(carNames).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingGame(cars);
    }
}
