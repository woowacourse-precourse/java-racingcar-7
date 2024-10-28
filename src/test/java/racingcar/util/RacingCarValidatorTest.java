package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingCarValidatorTest extends NsTest {

    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    @Test
    @DisplayName("자동차의 이름에 대한 조건을 만족하면 예외가 발생하지 않는다")
    void t001() {
        String testInput = ("a").repeat(MAX_CAR_NAME_LENGTH);

        assertThatCode(() -> {
            racingCarValidator.validateCarName(testInput);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차의 이름이 일정 글자수를 넘으면 예외가 발생한다")
    void t002() {
        String testInput = ("a").repeat(MAX_CAR_NAME_LENGTH) + "a";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarValidator.validateCarName(testInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수에는 숫자 이외의 것이 입력될 수 없다")
    void t003() {
        String testInput = "둘";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarValidator.raceCountParsingValidate(testInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수에는 음수가 입력될 수 없다")
    void t004() {
        String testInput = "-3";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarValidator.raceCountNegativeNumberValidate(testInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수에는 소수가 입력될 수 없다")
    void t005() {
        String testInput = "3.3";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarValidator.raceCountDecimalValidate(testInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수에 대한 유효성 검사를 진행할 수 있다")
    void t006() {
        String testInput = "5";

        assertThatCode(() -> {
            racingCarValidator.validateRaceCount(testInput);
        }).doesNotThrowAnyException();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}