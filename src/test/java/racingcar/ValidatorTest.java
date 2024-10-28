package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class ValidatorTest {

    @Test
    void 입력값을_분리하고_검증한다() {
        String input = "자동차1,자동차2";
        List<String> result = Validator.validateInput(input);
        assertThat(result).containsExactly("자동차1", "자동차2");
    }

    @Test
    void 빈_입력값일_경우_예외가_발생한다() {
        String input = "";
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차가 없습니다.");
    }

    @Test
    void 중복된_이름이_있을_경우_예외가_발생한다() {
        String input = "자동차1,자동차1";
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복되었습니다.");
    }

    @Test
    void 이름_길이가_5자를_초과할_경우_예외가_발생한다() {
        String input = "자동차1,자동차222";
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @Test
    void 시도횟수를_정수로_파싱한다() {
        String input = "3";
        int result = Validator.parseAttempts(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 시도횟수가_정수가_아닐_경우_예외가_발생한다() {
        String input = "a";
        assertThatThrownBy(() -> Validator.parseAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 시도횟수가_최소값_미만일_경우_예외가_발생한다() {
        int attempts = 0;
        assertThatThrownBy(() -> Validator.checkAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상 이어야합니다.");
    }
}
