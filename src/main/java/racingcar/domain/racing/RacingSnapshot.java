package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.CarSnapshot;

public record RacingSnapshot(List<CarSnapshot> carSnapshots) {

}
