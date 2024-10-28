package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("자동차 이름이 null이거나 빈 문자열인 경우 예외 발생")
    void validateNullOrEmptyCarNames() {
        assertThatThrownBy(() -> validator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 영문자와 숫자가 아닌 특수 문자가 포함된 경우 예외 발생")
    void validateSpecialCharactersInCarNames() {
        assertThatThrownBy(() -> validator.validateCarNames("mins,mi@ns"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    void validateEmptyNameAfterTrim() {
        assertThatThrownBy(() -> validator.validateCarNames("mins, ,mini"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateCarNames("mins,,mini"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되는 경우 예외 발생")
    void validateDuplicateCarNames() {
        assertThatThrownBy(() -> validator.validateCarNames("mini,mini"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void validateCarNameLength() {
        assertThatThrownBy(() -> validator.validateCarNames("mini,minifivewords"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateCarNames("mini,fivewo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 2대 미만인 경우 예외 발생")
    void validateMinCarCount() {
        assertThatThrownBy(() -> validator.validateCarNames("mini"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 자동차 이름 입력의 경우 리스트 반환")
    void validateValidCarNames() {
        assertThat(validator.validateCarNames("mini,mins")).contains("mini", "mins");
    }

    @Test
    @DisplayName("시도 횟수가 null이거나 빈 문자열인 경우 예외 발생")
    void validateNullOrEmptyRounds() {
        assertThatThrownBy(() -> validator.validateRounds(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateRounds(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생")
    void validateNonNumericRounds() {
        assertThatThrownBy(() -> validator.validateRounds("number"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateRounds("숫자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 1 미만인 경우 예외 발생")
    void validateNegativeRounds() {
        assertThatThrownBy(() -> validator.validateRounds("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateRounds("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 시도 횟수 입력의 경우 검증 통과")
    void validateValidRounds() {
        validator.validateRounds("5");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
