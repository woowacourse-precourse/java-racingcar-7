package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountInputTest {

    @Test
    void 시도_횟수가_null이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new TryCountInput(null))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("null은 입력할 수 없습니다.");
    }

    @Test
    void 시도_횟수가_빈문자열이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new TryCountInput(""))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("빈 문자열은 입력할 수 없습니다.");
    }
}
