package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
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
