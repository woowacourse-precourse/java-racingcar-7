package racingcar.object.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.object.enums.RaceMaxCounts;

class MileageTest {

    private static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 주행거리가_null_또는_음수_또는_최대랩수초과면_예외발생() {
        assertThatThrownBy(() -> new Mileage(null))
                .isInstanceOf(COMMON_EXCEPTION);

        assertThatThrownBy(() -> new Mileage(-1))
                .isInstanceOf(COMMON_EXCEPTION);

        assertThatThrownBy(() ->
                new Mileage(RaceMaxCounts.MAX_COUNT_OF_LAP.getCount() + 1))
                .isInstanceOf(COMMON_EXCEPTION);
    }

    @Test
    void getIncreased로_주행거리가_1증가한다() {
        Integer initDistance = 3;
        Mileage initMileage = new Mileage(initDistance);
        Mileage increasedMileage = initMileage.getIncreased();

        assertThat(increasedMileage.distance()).isEqualTo(initDistance + 1);
    }

    @Test
    void compareTo로_주행거리_비교할수있다() {
        Mileage smaller = new Mileage(3);
        Mileage larger = new Mileage(4);

        assertThat(larger.compareTo(smaller)).isEqualTo(1);
        assertThat(smaller.compareTo(larger)).isEqualTo(-1);
        assertThat(smaller.compareTo(smaller)).isEqualTo(0);
    }

}