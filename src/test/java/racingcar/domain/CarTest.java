package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessages.NAME_LENGTH_ERROR_MESSAGE;

class CarTest {
    @Test
    void 자동차는_이름을_가진다() {
        // given
        final var car = new Car("sumin");

        // then
        assertThat(car.getName()).isEqualTo("sumin");
    }

    @Test
    void 자동차_이름은_1자_이상_5자_이하여야_한다() {
        // when & then
        assertThatThrownBy(() -> new Car("jinyoung"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void 자동차는_전진할_수_있다_4이상_숫자일_경우() {
        // given
        final var car = new Car("sumin");

        // when
        car.move(5);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_전진할_수_없다_4미만_숫자일_경우() {
        // given
        final var car = new Car("sumin");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}