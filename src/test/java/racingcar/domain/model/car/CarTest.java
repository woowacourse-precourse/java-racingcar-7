package racingcar.domain.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("올바른 입력 값을 처리할 수 있다.")
    void 정상_케이스() {
        // given
        final String input = "자동차!";

        // when
        final Car car = Car.from(input);

        // then
        assertThat(car.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("다섯 글자를 넘는 이름은 설정할 수 없다.")
    void 예외_이름_다섯_글자_초과() {
        // given
        final String input = "일이삼사오육";

        // when & then
        assertThatThrownBy(() -> {
            Car.from(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("공백은 이름으로 설정할 수 없다.")
    @ValueSource(strings = {"", " ", "      "})
    void 예외_이름_공백(String input) {
        // given
        // when & then
        assertThatThrownBy(() -> {
            Car.from(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("앞,뒤 공백은 무시한다.")
    @ValueSource(strings = {"   일이삼사오   ", "    123"})
    void 정상_이름_앞_뒤_공백_무시(String input) {
        // given
        // when
        Car car = Car.from(input);

        // then
        assertThat(car.getName()).isEqualTo(input.trim());
    }
}