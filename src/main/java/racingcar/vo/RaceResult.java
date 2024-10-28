package racingcar.vo;

import java.util.List;
import racingcar.domain.CarRacer;

public record RaceResult<T>(
        List<T> winners,
        List<String> histories
) {

    public static <T> RaceResult<T> of(List<T> winners, List<String> histories) {
        return new RaceResult<>(winners, histories);
    }
}
