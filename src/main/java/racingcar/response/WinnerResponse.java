package racingcar.response;

import java.util.List;
import racingcar.domain.Car;

public record WinnerResponse(List<Car> winners) {
}