package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 빈 문자열 입력")
    void blankInput() {
        //given
        final String input = "";

        //when & then
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차의 이름을 입력해 주세요.");
    }

}