package racingcar.object;

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

        assertThatThrownBy(() -> new Mileage(RaceMaxCounts.MAX_COUNT_OF_LAP.getCount() + 1))
                .isInstanceOf(COMMON_EXCEPTION);
    }

    @Test
    void 주행거리를_increase하면_1증가한다() {
        Integer initMileage = 3;
        Mileage mileage = new Mileage(initMileage);
        mileage.increase();
        assertThat(mileage.getMileage()).isEqualTo(initMileage + 1);
    }

    @Test
    void 주행거리를_getMileage로_확인할수있다() {
        Integer initMileage = 3;
        Mileage mileage = new Mileage(initMileage);
        assertThat(mileage.getMileage()).isEqualTo(initMileage);
    }

    @Test
    void 주행거리를_compareTo로_비교할수있다() {
        Mileage smaller = new Mileage(3);
        Mileage larger = new Mileage(4);

        assertThat(larger.compareTo(smaller)).isEqualTo(1);
        assertThat(smaller.compareTo(larger)).isEqualTo(-1);
        assertThat(smaller.compareTo(smaller)).isEqualTo(0);
    }

}