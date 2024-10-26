package racingcar.domain.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacerNameTest {

    @Test
    @DisplayName("자동차 이름이 빈 값일 경우, 예외가 발생한다.")
    void givenEmptyName_whenCreate_thenThrowException() {
        // given
        String name = "";

        // when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null 값일 경우, 예외가 발생한다.")
    void givenNullValueName_whenCreate_thenThrowException() {
        // given
        String name = null;

        // when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 경우, 예외가 발생한다.")
    void givenSixLengthName_whenCreate_thenThrowException() {
        // given
        String name = "a".repeat(6);

        // when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 주어질 경우, 정상적으로 생성된다.")
    void givenName_whenCreate_thenNameEqualToCarName() {
        // given
        String name = "a".repeat(5);

        // when
        CarName car = new CarName(name);

        // then
        assertThat(car.value()).isEqualTo(name);
    }

}