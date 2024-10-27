package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;

class CarNamesTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 빈 문자열 입력")
    void blankInput() {
        //given
        final String input = "";

        //when & then
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_CAR_NAME_INPUT.getMessage());
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 이름을 공백인 경우")
    void blankCarName() {
        //given
        final String input = "a, ,c";

        //when & then
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 이름이 5자 이상인 경우")
    void tooLongCarName() {
        //given
        final String input = "a,b,cdefghi";

        //when & then
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_LONG_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 중복된 이름 입력")
    void duplicatedCarName() {
        //given
        final String input = "a,a,c";

        //when & then
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }

}