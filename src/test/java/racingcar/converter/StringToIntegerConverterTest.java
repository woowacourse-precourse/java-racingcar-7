package racingcar.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessage;

class StringToIntegerConverterTest {

    @Nested
    class String_To_Integer_변환_테스트 {
        Converter<String, Integer> converter = new StringToIntegerConverter();

        @Test
        void String_타입의_입력을_Integer_타입으로_변환할_수_있다() {
            // given
            String input = "5";

            // when
            Integer convertedInput = converter.convert(input);

            // then
            assertThat(convertedInput).isInstanceOf(Integer.class);
        }

        @Test
        void 양의_정수가_아닌_String_값을_변환할_수_없다() {
            // given
            String input = "5.5";

            // when & then
            assertThatThrownBy(() -> converter.convert(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}