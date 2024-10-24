package racingcar.dto;

import racingcar.model.RacingCars;

import java.util.List;

public record RacingResult(List<RacingRoundResult> roundResults, RacingCars winners) {

    public RacingCars winners() {
        return new RacingCars(winners);
    }
}
