package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {

    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("정상 자동차 입력이 주어진 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni", "pobi,andf,woni", "pobi, java, kot", "pobi"})
    void 정상_자동차_입력(String inputString) {
        assertThat(validation.isRightInputName(inputString)).isEqualTo(true);
    }

    @DisplayName("정상 자동차 입력이 주어지지 않는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni", "pobi,javaji", ""})
    void 예외_자동차_입력(String inputString) {
        assertThat(validation.isRightInputName(inputString)).isEqualTo(false);
    }

    @DisplayName("정상 카운트가 주어지는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"123", "5", "8", Integer.MAX_VALUE + ""})
    void 정상_횟수_입력(String inputString) {
        assertThat(validation.isRightCount(inputString)).isEqualTo(true);
    }

    @DisplayName("정상 카운트가 주어지지 않는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"-123", "ab", "", "123ab", "1ab34"})
    void 에러_횟수_입력(String inputString) {
        assertThat(validation.isRightCount(inputString)).isEqualTo(false);
    }
}
