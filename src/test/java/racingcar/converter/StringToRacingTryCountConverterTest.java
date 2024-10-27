package racingcar.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringToRacingTryCountConverterTest {

    StringToRacingTryCountConverter converter;

    @BeforeEach
    void before() {
        converter = new StringToRacingTryCountConverter();
    }

    @Test
    void TDD_시도할_횟수_입력값_성공() {
        //given
        String input = "5";

        //when
        int racingTryCount = converter.convert(input);

        //then
        assertThat(racingTryCount).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void TDD_시도할_횟수_숫자_실패() {
        //given
        String input = "a";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_시도할_횟수_정수_실패() {
        //given
        String input = "0";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수_실수_실패() {
        //given
        String input = "1.1";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수_양수_범위_초과_실패() {
        //given
        String input = "9999999999999999999999999";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
