package racingcar.domain.race;

import racingcar.util.NumberGenerator;

public class Race {
    private final RaceCount raceCount;
    private final NumberGenerator randomNumberGenerator;

    private Race(final String raceCount, final NumberGenerator randomNumberGenerator) {
        this.raceCount = RaceCount.from(raceCount);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Race of(String raceCount, NumberGenerator randomNumberGenerator) {
        return new Race(raceCount, randomNumberGenerator);
    }

}
