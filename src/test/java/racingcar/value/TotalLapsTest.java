package racingcar.value;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TotalLapsTest {

    @Test
    void 올바른_매개변수로_생성에_성공할_것이다() {
        final var count = 5L;

        final var totalLaps = new TotalLaps(count);

        assertThat(totalLaps.count()).isEqualTo(5L);
    }

    @Test
    void 최솟값인_1미만으로_생성시_익셉션이_발생할_것이다() {
        final var count = 0L;

        assertThatThrownBy(() -> new TotalLaps(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최솟값과_같은_1로_생성시_생성에_성공할_것이다() {
        final var count = 1L;

        final var totalLaps = new TotalLaps(count);

        assertThat(totalLaps.count()).isEqualTo(1L);
    }
}