package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    private Car pobi;
    private Car woni;
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi", () -> true);
        woni = new Car("woni", () -> false);
        racingCars = new RacingCars(List.of(pobi, woni));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 레이싱_시도_횟수가_1미만이라면_예외를_반환한다(int tryCount) {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Racing(racingCars, tryCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_POSITIVE_NUMBER.getMessage());
    }

    @Test
    void 경주가_횟수만큼_정상적으로_진행된다() {
        // given
        int tryCount = 3;
        Racing racing = new Racing(racingCars, tryCount);

        // when
        RacingResult result = racing.play();

        // then
        assertThat(result.getSnapshots()).hasSize(tryCount);
    }

    @Test
    void 스냅샷이_경주_횟수만큼_저장된다() {
        // given
        int tryCount = 2;
        Racing racing = new Racing(racingCars, tryCount);

        // when
        RacingResult result = racing.play();

        // then
        int expectedCarSize = 2;
        List<RacingSnapshot> snapshots = result.getSnapshots();
        assertThat(snapshots).hasSize(tryCount);

        snapshots.forEach(snapshot -> assertThat(snapshot.carSnapshots()).hasSize(expectedCarSize));
    }
}
