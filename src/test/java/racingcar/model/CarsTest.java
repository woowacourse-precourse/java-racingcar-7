package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 최대_전진_횟수를_구한다() {
        // given
        String[] carNames = {"pobi", "woni"};
        Cars cars = Cars.from(carNames);

        cars.getCars()
            .get(0)
            .addAdvanceMarker(); // pobi: 1회 전진
        cars.getCars()
            .get(1)
            .addAdvanceMarker(); // woni: 1회 전진
        cars.getCars()
            .get(1)
            .addAdvanceMarker(); // woni: 2회 전진

        // when
        int maxAdvanceMarkerCount = cars.getMaxAdvanceMarkerCount();

        // then
        assertThat(maxAdvanceMarkerCount).isEqualTo(2);
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi", "woni", "woni"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_2개_미만이면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
