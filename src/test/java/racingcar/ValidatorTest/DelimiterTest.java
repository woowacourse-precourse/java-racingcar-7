package racingcar.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class DelimiterTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("유효한 입력값 테스트")
    void ValidateRightInput() {
        assertThatCode(() -> validator.validateInput("asd,qwe", 2))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("잘못된 구분자 테스트 - 다른 문자로 구분")
    void ValidateWrongDelimiter() {
        assertThatCode(() -> validator.validateInput("asd.qwe", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 쉼표(,)만을 사용하셔야 합니다.");
    }

    @Test
    @DisplayName("잘못된 구분자 테스트 - 구분자 두개 사용")
    void ValidateUseDelimiterTwice() {
        assertThatCode(() -> validator.validateInput("asd,,qwe", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 쉼표(,)만을 사용하셔야 합니다.");
    }

    @Test
    @DisplayName("잘못된 구분자 테스트 - 문자열 앞에 구분자 사용")
    void ValidateFrontDelimiter() {
        assertThatCode(() -> validator.validateInput(",asd", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 쉼표(,)만을 사용하셔야 합니다.");
    }

    @Test
    @DisplayName("잘못된 구분자 테스트 - 문자열 뒤에 구분자 사용")
    void ValidateBackDelimiter() {
        assertThatCode(() -> validator.validateInput("asd,", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 쉼표(,)만을 사용하셔야 합니다.");
    }
}
