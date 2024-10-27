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
}
