package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName("Cars와 RacingCount로 경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi"),
                Car.from("woni"),
                Car.from("jun")
        ));

        RacingCount racingCount = RacingCount.from(1);

        //when
        Racing racing = Racing.of(cars, racingCount);

        //then
        assertThat(racing).isEqualTo(Racing.of(cars, racingCount));
    }
}