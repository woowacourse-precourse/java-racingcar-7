package racingcar.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.errormessage.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    @DisplayName("생성 테스트")
    void createNumberTest() {
        Name name = new Name("12345");
        assertThat(name).isEqualTo(new Name("12345"));
    }
    @Test
    @DisplayName("5 초과의 길이가 들어 올 경우")
    void withinRangeNameTest() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WITHIN_RANGE_ERROR_MESSAGE);

    }
}
