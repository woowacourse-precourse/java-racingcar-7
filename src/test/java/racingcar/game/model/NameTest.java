package racingcar.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.game.constant.ExceptionMessage.CAR_NAME_IS_BLANK;
import static racingcar.game.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

class NameTest {
    @Test
    @DisplayName("정상적인 자동차 이름 생성")
    void createName_ValidInput() {
        // given
        String validName = "car1";

        // when
        Name name = new Name(validName);

        // then
        assertEquals(validName, name.getName());
    }

    @Test
    @DisplayName("자동차 이름 길이 초과 예외 발생")
    void createName_TooLongName() {
        // given
        String longName = "car123";

        // when & then
        assertThatThrownBy(() -> new Name(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 길이 미달 예외 발생")
    void createName_TooShortName() {
        // given
        String shortName = "";

        // when & then
        assertThatThrownBy(() -> new Name(shortName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_BLANK.getMessage());
    }
}