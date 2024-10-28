package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.CarNameValidator.validate;
import static racingcar.validator.CarNameValidator.validateNames;
import static racingcar.validator.RaceValidator.validateRounds;
import static racingcar.validator.RaceValidator.validateRoundsInput;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void 자동차_이름이_빈_문자열일_때_예외발생() {
        assertThatThrownBy(() -> validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_자동차_이름_리스트는_예외_발생하지_않음() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        validateNames(carNames); // 예외가 발생하지 않으면 테스트 통과
    }

    @Test
    void 시도_횟수가_숫자가_아닐_때_예외발생() {
        assertThatThrownBy(() -> validateRoundsInput("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_음수일_때_예외발생() {
        assertThatThrownBy(() -> validateRounds(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_올바른_숫자일_때_예외_발생하지_않음() {
        validateRounds(5); // 예외가 발생하지 않으면 테스트 통과
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
