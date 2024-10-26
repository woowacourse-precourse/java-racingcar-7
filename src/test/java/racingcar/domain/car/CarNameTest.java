package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 이름을 공백으로 입력")
    void blackCarName() {
        //given
        final String name = "";

        //when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름을 지정하지 않은 자동차가 있습니다.");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 이름이 5자 이상")
    void tooLongCarName() {
        //given
        final String name = "abcdef";

        //when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하로 설정해 주세요.");
    }
}