package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void 숫자가_3_이하이면_정지하고_4_이상이면_전진한다(int number, int expected) {
        // given
        Car car = Car.from("pobi");

        // when
        car.advance(number);

        // then
        assertThat(car.getAdvanceMarkerCount()).isEqualTo(expected);
    }

    @Test
    void 이름이_6자_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> Car.from("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자_이하이면_예외가_발생하지_않는다() {
        assertThatCode(() -> Car.from("일이삼사오"))
                .doesNotThrowAnyException();
    }
}
