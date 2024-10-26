package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarServiceTest {
    @Test
    public void 자동차_이름_구분() {
        // given
        String carNamesInput = "pobi,woni,jun";
        RacingCarService service = new RacingCarService();

        // when
        Race race = service.createRace(carNamesInput);

        // then
        assertThat(race.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(race.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(race.getCars().get(2).getName()).isEqualTo("jun");
    }
}
