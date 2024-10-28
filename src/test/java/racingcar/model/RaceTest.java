package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void 레이스_우승자_선정() {
        // given
        Race race = new Race("pobi,woni,jun");

        // when

        // then
        assertThat(race.runRace(3)).isNotEmpty();
    }
}
