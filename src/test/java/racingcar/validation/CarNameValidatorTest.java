package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    private CarNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @Test
    void 한_대의_자동차_이름을_입력한다() {
        assertThatCode(() -> validator.validateCarNames(List.of("pobi")))
                .doesNotThrowAnyException();
    }

    @Test
    void 여러_대의_자동차_이름을_입력한다() {
        assertThatCode(() -> validator.validateCarNames(List.of("pobi", "hello")))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름에_공백을_포함해서_입력하면_공백이_제거된다() {
        assertThatCode(() -> validator.validateCarNames(List.of("pobi", "hello")))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_테스트_자동차_이름을_입력하지_않으면_실패한다() {
        assertThatThrownBy(() -> validator.validateCarNames(List.of("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 대 이상의 자동차 이름을 입력해야 합니다.");
    }

    @Test
    void 예외_테스트_자동차_이름이_중복이면_실패한다() {
        assertThatThrownBy(() -> validator.validateCarNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중북된 자동차 이름을 입력할 수 없습니다.");
    }

    @Test
    void 예외_테스트_자동차_이름_길이가_6_이상이면_실패한다() {
        assertThatThrownBy(() -> validator.validateCarNames(List.of("helloworld")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 길이는 6 이상이 될 수 없습니다.");
    }
}