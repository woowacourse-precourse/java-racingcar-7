package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    void TDD_경주_자동차_2대_이상_성공() {
        //given
        String input = "pobi,woni";

        //when
        RacingCars racingCars = RacingCars.from(input);

        //then
        assertThat(racingCars.getCars()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void TDD_경주_자동차_2대_이상_조건_실패() {
        //given
        String input = "pobi";

        //when
        assertThatThrownBy(() -> RacingCars.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_자동차_중_가장_많이_이동한_거리_가져오기() {
        //given
        String input = "pobi,woni";
        RacingCars racingCars = RacingCars.from(input);

        //when
        int maxPosition = racingCars.getMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(0);
    }
}
