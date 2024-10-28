package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.ErrorMessage.NOT_CAR_NAME_OVER_FIVE;
import static racingcar.common.ErrorMessage.NOT_NULL_AND_NOT_BLANK;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {
    @Test
    void 자동차_이름은_5자_보다_크면_예외_발생() {
        String name = "daesun";
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_CAR_NAME_OVER_FIVE.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름이_빈문자열이거나_null일경우_예외_발생(String name){
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NULL_AND_NOT_BLANK.getMessage());
    }
}