package racingcar;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.SizeValidator;

class SizeValidatorTest {

    static final Integer MIN_LENGTH = 0;
    static final Integer MAX_LENGTH = 5;
    static final String ERROR_MESSAGE = "%d자 초과, %d자 이하만 가능합니다.";

    SizeValidator sizeValidator = new SizeValidator();

    @Test
    @DisplayName("5글자 초과시 IllegalArgumentException 발생")
    void 글자길이_초과시_에러발생() {
        // given
        List<String> rawCarNames = List.of("sizeOver");

        // when & then
        whenAndThen(rawCarNames);
    }

    @Test
    @DisplayName("비어있는 이름은 IllegalArgumentException 발생")
    void 비어있는_이름_에러발생() {
        // given
        List<String> rawCarNames = List.of("");

        // when & then
        whenAndThen(rawCarNames);
    }

    @Test
    @DisplayName("비어있는 이름이 한개라도 포함시 IllegalArgumentException 발생")
    void 비어있는_이름이_한개라도_포함시_에러발생() {
        // given
        List<String> rawCarNames = List.of("", "a");

        // when & then
        whenAndThen(rawCarNames);
    }

    private void whenAndThen(List<String> rawCarNames) {
        assertThatThrownBy(() -> sizeValidator.check(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ERROR_MESSAGE, MIN_LENGTH, MAX_LENGTH));
    }

}