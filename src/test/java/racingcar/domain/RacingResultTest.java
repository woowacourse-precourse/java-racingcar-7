package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    private Car pobi;
    private Car woni;
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi", () -> true);
        woni = new Car("woni", () -> false);
    }

    @Test
    void 우승자를_결정한다() {
        //given
        racingCars = new RacingCars(List.of(pobi, woni));
        racingCars.move();
        RacingSnapshot racingSnapshot = new RacingSnapshot(racingCars.getSnapshots());
        List<RacingSnapshot> snapshots = List.of(racingSnapshot);

        //when
        RacingResult racingResult = new RacingResult(racingCars, snapshots);

        //then
        assertWinner(racingResult, pobi);
    }

    @Test
    void 우승자가_여러명이라면_모두_반환한다() {
        //given
        woni = new Car("woni", () -> true);
        racingCars = new RacingCars(List.of(pobi, woni));
        racingCars.move();
        RacingSnapshot racingSnapshot = new RacingSnapshot(racingCars.getSnapshots());
        List<RacingSnapshot> snapshots = List.of(racingSnapshot);

        //when
        RacingResult racingResult = new RacingResult(racingCars, snapshots);

        //then
        assertWinner(racingResult, pobi, woni);
    }

    private void assertWinner(RacingResult result, Car... expectedWinners) {
        assertThat(result.getWinner())
                .containsExactly(
                        List.of(expectedWinners).stream()
                                .map(Car::getName)
                                .toArray(String[]::new)
                );
    }
}
