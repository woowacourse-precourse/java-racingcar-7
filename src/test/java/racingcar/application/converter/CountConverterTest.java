package racingcar.application.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CountConverterTest {

    @Test
    public void 문자열_형태의_정수를_변환할_수_있다() throws Exception {
        //given
        CountConverter countConverter = new CountConverter();

        //when
        Integer result = countConverter.convert("1");

        //then
        assertThat(result).isEqualTo(1);
    }
}