package racingcar.vo;

import java.util.List;
import racingcar.domain.CarRacer;

public record CarRaceResult(
        List<CarRacer> winners,
        List<String> histories
) {

    public static CarRaceResult of(List<CarRacer> winners, List<String> histories) {
        return new CarRaceResult(winners, histories);
    }
}
