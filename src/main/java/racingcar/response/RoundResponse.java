package racingcar.response;

import java.util.List;
import racingcar.domain.Car;

public record RoundResponse(List<Car> cars, boolean gameEnd) {
}