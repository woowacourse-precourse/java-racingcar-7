package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 빈_문자열_입력() {
        assertThatThrownBy(() -> Validator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용할 수 있는 이름이 없습니다.");
    }

    @Test
    void 공백_문자열_입력() {
        assertThatThrownBy(() -> Validator.validateCarNames("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용할 수 있는 이름이 없습니다.");
    }

    @Test
    void 길이가_5_초과인_문자열_입력() {
        List<String> carNames = List.of("longtester", "lisa");
        assertThatThrownBy(() -> Validator.validateEachCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 이름 중 길이가 5자를 초과한 이름이 있습니다.");
    }

    @Test
    void 길이가_5_이하인_문자열_입력() {
        List<String> carNames = List.of("june", "lisa");
        assertThatNoException().isThrownBy(() -> Validator.validateEachCarNames(carNames));
    }

    @Test
    void 숫자가_아닌_값_입력() {
        assertThatThrownBy(() -> Validator.validateIsNumeric("string"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Rounds 수에는 숫자만 허용됩니다.");
    }

    @Test
    void 자연수가_아닌_시도횟수_입력() {
        assertThatThrownBy(() -> Validator.validateTryRounds(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Rounds 수는 1 이상이여야 합니다.");
    }

    @Test
    void 음수인_시도횟수_입력() {
        assertThatThrownBy(() -> Validator.validateTryRounds(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Rounds 수는 1 이상이여야 합니다.");
    }
}
