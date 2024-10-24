package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.randomnumber.RandomNumberGenerator;

class RacingTest {

    @DisplayName("Cars와 RacingCount로 경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        RacingCount racingCount = RacingCount.from(1);

        //when
        Racing racing = Racing.of(cars, racingCount);

        //then
        assertThat(racing).isEqualTo(Racing.of(cars, racingCount));
    }
}