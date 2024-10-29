package racingcar.racing.dto.response;

import java.util.List;
import racingcar.racing.domain.Car;

public record CarResult(String name, List<Integer> positionPerRound, Boolean isWinner) {

    public static CarResult from(Car car) {
        return new CarResult(car.getName(), car.getPositionLog(), car.getWinner());
    }
}
