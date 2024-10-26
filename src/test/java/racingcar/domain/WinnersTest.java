package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final int ATTEMPT_COUNT = 5;
    private static final String EXPECTED = "pobi, woni, jun";


    @Test
    void printWinnersAccordingToFormat() {
        Race race = Race.createRace(CAR_NAMES, ATTEMPT_COUNT);

        Winners winners = Winners.createWinners(race.getWinners());

        assertThat(winners.displayWinners())
                .isEqualTo(EXPECTED);
    }
}