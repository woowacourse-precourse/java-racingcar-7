package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarState;

public record RoundScores(List<CarState> carStates) {
}
