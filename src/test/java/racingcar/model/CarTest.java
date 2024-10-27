package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 이름이_6자_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> Car.from("미래소년코난"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자_이하이면_예외가_발생하지_않는다() {
        assertThatCode(() -> Car.from("배고픈포비"))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자가_4_이상이면_전진한다() {
        // given
        Car car = Car.from("pobi");

        // when
        car.advance(4);

        // then
        assertThat(car.getAdvanceMarkerCount()).isEqualTo(1);
    }

    @Test
    void 숫자가_3_이하이면_움직이지_않는다() {
        // given
        Car car = Car.from("pobi");

        // when
        car.advance(3);

        // then
        assertThat(car.getAdvanceMarkerCount()).isEqualTo(0);
    }

}
