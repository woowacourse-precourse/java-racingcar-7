package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;
import racingcar.utils.TryCountParser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class TryCountParserTest {

    @Test
    void 유효한_시도_횟수를_정수로_파싱한다() {
        String input = "5";
        int result = TryCountParser.parseTryCount(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 숫자가_아닌_입력을_주면_예외를_발생시킨다() {
        String input = "abc";

        assertThatThrownBy(() -> TryCountParser.parseTryCount(input))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("시도할 횟수는 최소 1 이상의 양의 정수이어야 합니다.");
    }
}
