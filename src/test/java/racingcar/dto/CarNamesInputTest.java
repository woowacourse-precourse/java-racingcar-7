package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesInputTest {

    @Test
    void 자동차_이름이_null이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new CarNamesInput(null))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("null은 입력할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_빈문자열이면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new CarNamesInput(""))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("빈 문자열은 입력할 수 없습니다.");
    }
}
