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
        RacingCars racingCars = new RacingCars(input);

        //then
        assertThat(racingCars.getCars()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void TDD_경주_자동차_2대_이상_조건_실패() {
        //given
        String input = "pobi";

        //when
        assertThatThrownBy(() -> new RacingCars(input).ready()).isInstanceOf(IllegalArgumentException.class);
    }
}
