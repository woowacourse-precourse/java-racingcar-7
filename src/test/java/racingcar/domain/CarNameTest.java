package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 테스트")
public class CarNameTest {

    @Test
    @DisplayName("자동차의 이름이 5를 초과할 경우, 예외를 발생시킨다.")
    void test_car_name_is_over_5() {
        // given
        final String car_name = "dddddd";

        // when & then
        assertThatThrownBy(() -> new CarName(car_name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 공백인 경우, 예외를 발생시킨다.")
    void test_car_name_is_blank() {
        // given
        final String car_name = " ";

        // when & then
        assertThatThrownBy(() -> new CarName(car_name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이거나 null 일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 null인 경우, 예외를 발생시킨다.")
    void test_car_name_is_null() {
        // given
        final String car_name = "";

        // when & then
        assertThatThrownBy(() -> new CarName(car_name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이거나 null 일 수 없습니다.");
    }
}
