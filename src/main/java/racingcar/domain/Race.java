package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int START_ROUND = 1;
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 100;
    private static final String RACE_ROUND_LENGTH_ERROR_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하여야 합니다.", MIN_ROUND, MAX_ROUND);

    private final int raceRound;
    private final Cars cars;
    private final List<RaceLog> raceLogs;

    private Race(int raceRound, Cars cars) {
        this.raceRound = raceRound;
        this.cars = cars;
        this.raceLogs = new ArrayList<>();
    }

    public static Race from(int raceRound, Cars cars) {
        validateRaceRound(raceRound);
        return new Race(raceRound, cars);
    }

    private static void validateRaceRound(int raceRound) {
        if (raceRound < MIN_ROUND || raceRound > MAX_ROUND) {
            throw new IllegalArgumentException(RACE_ROUND_LENGTH_ERROR_MESSAGE);
        }
    }

    public void play() {
        for (int round = START_ROUND; round <= raceRound; round++) {
            cars.moveAll();
            raceLogs.add(RaceLog.from(round, cars));
        }
    }
}
