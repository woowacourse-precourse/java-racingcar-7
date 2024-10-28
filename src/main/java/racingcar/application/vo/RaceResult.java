package racingcar.application.vo;

import java.util.List;

public record RaceResult<T>(
        List<T> winners,
        List<String> histories
) {

    public static <T> RaceResult<T> of(List<T> winners, List<String> histories) {
        return new RaceResult<>(winners, histories);
    }
}
