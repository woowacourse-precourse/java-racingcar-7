package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final int ATTEMPT_COUNT = 5;
    private static final String EXPECTED = "pobi, woni, jun";


    @Test
    @DisplayName("우승자 출력 형식에 맞게 정상 출력해야 한다.")
    void printWinnersAccordingToFormat() {
        //given
        Race race = Race.createRace(CAR_NAMES, ATTEMPT_COUNT);

        //when
        Winners winners = Winners.createWinners(race.getWinners());

        //then
        assertThat(winners.displayWinners())
                .isEqualTo(EXPECTED);
    }
}