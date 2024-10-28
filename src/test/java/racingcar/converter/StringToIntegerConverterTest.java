package racingcar.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringToIntegerConverterTest {

    @Test
    void String_타입의_입력을_Integer_타입으로_변활할_수_있다() {
        // given
        Converter<String, Integer> converter = new StringToIntegerConverter();
        String input = "5";

        // when
        Integer convertedInput = converter.convert(input);

        // then
        assertThat(convertedInput).isInstanceOf(Integer.class);
    }
}