package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.randomnumber.RandomNumberGenerator;

class RacingTest {

    @DisplayName("경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        //when
        Racing racing = Racing.from(cars);

        //then
        assertThat(racing).isEqualTo(Racing.from(cars));
    }
}