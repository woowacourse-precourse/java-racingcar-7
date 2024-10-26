package racingcar.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringToRacingTryCountConverterTest {

    StringToRacingTryCountConverter stringToRacingTryCountConverter;

    @BeforeEach
    void before() {
        stringToRacingTryCountConverter = new StringToRacingTryCountConverter();
    }

    @Test
    void TDD_시도할_횟수_입력값_성공() {
        //given
        String input = "5";

        //when
        int racingTryCount = stringToRacingTryCountConverter.convert(input);

        //then
        assertThat(racingTryCount).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void TDD_시도할_횟수_숫자_검증_실패() {
        //given
        String input = "a";

        //when
        assertThatThrownBy(() -> stringToRacingTryCountConverter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_시도할_횟수_양수_검증_실패() {
        //given
        String input = "0";

        //when
        assertThatThrownBy(() -> stringToRacingTryCountConverter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
