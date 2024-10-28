package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 자동차_이름_입력시_쉼표로_시작하거나_끝나면_예외_발생() {
        // given
        String input = ",a,b,c,";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 처음과 끝에 존재할 수 없습니다.");
    }

    @Test
    void 시도할_횟수_입력시_양수가_아니면_예외_발생() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> InputParser.parseTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }
}
