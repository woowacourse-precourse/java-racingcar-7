package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingTest {
    private Racing racing;

    @BeforeEach
    void init() {
        List<String> racingCarNames = List.of("pobi", "woni", "jun");
        racing = new Racing(racingCarNames);
    }

    @Test
    void 모든_자동차가_이동하는지_확인한다() {
        racing.run(() -> 5);

        for (RacingCar racingCar : racing.getCars()) {
            assertThat(racingCar.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 현재_가장_멀리_있는_자동차를_알_수_있다() {
        // given
        racing.getCars().get(0).moveForward(() -> 5); // pobi 전진
        racing.getCars().get(2).moveForward(() -> 5); // jun 전진

        // when
        List<RacingCar> farthestRacingCarList = racing.findFarthestCars();

        // then
        assertThat(farthestRacingCarList).hasSize(2)
                .extracting("name")
                .containsExactlyInAnyOrder("pobi", "jun");
    }
}
