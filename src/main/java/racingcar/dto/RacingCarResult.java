package racingcar.dto;

import java.util.List;

public record RacingCarResult(
        List<RacingCarProgress> progresses
) {

    public static RacingCarResult of(final List<RacingCarProgress> progresses) {
        return new RacingCarResult(progresses);
    }
}
