package racingcar.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameParserTest {
    @ParameterizedTest
    @DisplayName("빈 문자열은 자동차 이름으로 입력할 수 없다")
    @ValueSource(strings = {"", "철수,,영희", "     , 철수"})
    void 빈_문자열_예외(String input) {
        // given
        // when & then
        assertThatThrownBy(() -> {
            CarNameParser.parse(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름은 입력할 수 없다")
    void 중복_값_예외() {
        // given
        final String input = "철수, 철수";

        // when & then
        assertThatThrownBy(() -> {
            CarNameParser.parse(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}