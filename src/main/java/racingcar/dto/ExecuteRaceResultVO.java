package racingcar.dto;

import java.util.List;
import racingcar.domain.Vehicle;

public record ExecuteRaceResultVO(List<Vehicle> cars, String executeResult) {
}
