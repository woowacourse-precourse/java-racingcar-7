package racingcar.validation;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewValidatorTest {

    InputViewValidator inputViewValidator;

    @BeforeEach
    void setUp() {
        inputViewValidator = new InputViewValidator();
    }

    @Test
    void 한_대의_자동차_이름을_입력한다() {
        assertThatCode(() -> inputViewValidator.validateCarNames(List.of("pobi")))
                .doesNotThrowAnyException();
    }

    @Test
    void 여러_대의_자동차_이름을_입력한다() {
        assertThatCode(() -> inputViewValidator.validateCarNames(List.of("pobi", "hello")))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_테스트_자동차_이름을_입력하지_않으면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateCarNames(List.of("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 대 이상의 자동차 이름을 입력해야 합니다.");
    }

    @Test
    void 예외_테스트_자동차_이름이_중복이면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateCarNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중북된 자동차 이름을 입력할 수 없습니다.");
    }

    @Test
    void 예외_테스트_잘못된_구분자를_입력하면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateDelimiter("pobi&hello"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자를 입력했습니다.");
    }

    @Test
    void 예외_테스트_자동차_이름_길이가_6_이상이면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateCarNames(List.of("helloworld")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 길이는 6 이상이 될 수 없습니다.");
    }

    @Test
    void 이동_횟수_입력값이_숫자를_입력한다() {
        assertThatCode(() -> inputViewValidator.validateMoveThreshold("5"))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_테스트_이동_횟수_입력값이_숫자가_아니면_실패한다() {
        assertThatThrownBy(() -> inputViewValidator.validateMoveThreshold("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자를 입력해야 합니다.");
    }
}