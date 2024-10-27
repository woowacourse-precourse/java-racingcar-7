package racingcar.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConvertorTest {

    private Convertor convertor;

    @BeforeEach
    void set() {
        this.convertor = Convertor.init();
    }

    @Test
    void 정수_숫자_문자열을_Long으로_변환에_성공할_것이다() {
        final var value = "123";

        final var result = convertor.parseLong(value);

        assertThat(result).isEqualTo(123L);
    }

    @Test
    void 음수_숫자_문자열을_Long으로_변환에_성공할_것이다() {
        final var value = "-456";

        final var result = convertor.parseLong(value);

        assertThat(result).isEqualTo(-456L);
    }

    @Test
    void 숫자가_아닌_문자열은_익셉션이_발생할_것이다() {
        final var invalidValue = "abc";

        assertThatThrownBy(() -> convertor.parseLong(invalidValue))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_문자열은_익셉션이_발생할_것이다() {
        final var emptyValue = "";

        assertThatThrownBy(() -> convertor.parseLong(emptyValue))
            .isInstanceOf(IllegalArgumentException.class);
    }
}