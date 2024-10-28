package racingcar.dto;

import racingcar.model.RacingCarList;

public record RaceRequest(String command, int iterations, RacingCarList racingCarList) {
    public RaceRequest(String command, Integer iterations) {
        this(command, iterations, new RacingCarList());
    }

    public RaceRequest withCarList(RacingCarList racingCarList) {
        return new RaceRequest(this.command, this.iterations, racingCarList);
    }
}
