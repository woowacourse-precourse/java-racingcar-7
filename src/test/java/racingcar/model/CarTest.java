package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ValueSource(strings = {"pobi", "woni", "jun"})
    @ParameterizedTest
    void 자동차_이름은_5자_이하이어야_한다(final String name) {
        // given & when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ValueSource(strings = {"pobipobi", "woniwoni", "junjun"})
    @ParameterizedTest
    void 자동차_이름이_5자_초과면_에러가_발생한다(final String name) {
        // given & when & then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 랜덤한_수가_4_이상이면_자동차는_전진한다(final int condition) {
        // given
        Car car = new Car("pobi");

        // when
        car.move(condition);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 랜덤한_수가_4_미만이면_자동차는_제자리에_있어야_한다(final int condition) {
        // given
        Car car = new Car("pobi");

        // when
        car.move(condition);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
