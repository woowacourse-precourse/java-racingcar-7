package racingcar.domain.round;

import racingcar.domain.racer.Racer;

public record RoundResult(String carName, int position) {

    public static RoundResult from(Racer racer) {
        return new RoundResult(racer.getName(), racer.getPosition());
    }

}
