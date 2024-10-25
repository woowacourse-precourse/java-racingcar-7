package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    // TODO: race 테스트 작성하기. Random 값에 대한 구조 변경이 필요함.

    @DisplayName("가장 먼 위치에 있는 자동차가 우승한다.")
    @Test
    void test() {
        // given
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("winner1", 1),
                new RacingCar("loser1", 0),
                new RacingCar("winner2", 1)
        ));

        // when
        List<RacingCar> winners = racingCars.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("winner1", 1),
                        tuple("winner2", 1)
                );
    }

}
