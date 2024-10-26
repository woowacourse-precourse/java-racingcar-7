package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    InputViewValidator inputViewValidator;

    @BeforeEach
    void setUp() {
        inputViewValidator = new InputViewValidator();
    }

    @Test
    void 예외_테스트_잘못된_구분자를_입력하면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateDelimiter("pobi&hello"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자를 입력했습니다.");
    }

    @Test
    void 이동_횟수_입력값이_숫자를_입력한다() {
        assertThatCode(() -> inputViewValidator.validateMoveCount("5"))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_테스트_이동_횟수_입력값이_공백이면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateMoveCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자를 입력해야 합니다.");
    }

    @Test
    void 예외_테스트_이동_횟수_입력값이_숫자가_아니면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateMoveCount("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자를 입력해야 합니다.");
    }
}