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
    void 우승자_결정() {
        //given
        racingCars = new RacingCars(List.of(pobi, woni));
        racingCars.move();
        List<String> snapshot = List.of(pobi.toString(), woni.toString());

        //when
        RacingResult racingResult = new RacingResult(racingCars, snapshot);

        //then
        assertWinner(racingResult, pobi);
        assertSnapshot(racingResult, snapshot);
    }

    @Test
    void 우승자가_여러명일_때_결정() {
        //given
        woni = new Car("woni", () -> true);
        racingCars = new RacingCars(List.of(pobi, woni));
        racingCars.move();
        List<String> snapshot = List.of(pobi.toString(), woni.toString());

        //when
        RacingResult racingResult = new RacingResult(racingCars, snapshot);

        //then
        assertWinner(racingResult, pobi, woni);
        assertSnapshot(racingResult, snapshot);
    }

    private void assertWinner(RacingResult result, Car... expectedWinners) {
        assertThat(result.getWinner())
                .containsExactly(
                        List.of(expectedWinners).stream()
                                .map(Car::getName)
                                .toArray(String[]::new)
                );
    }

    private void assertSnapshot(RacingResult result, List<String> expectedSnapshot) {
        assertThat(result.getSnapshot()).containsExactlyElementsOf(expectedSnapshot);
    }
}
