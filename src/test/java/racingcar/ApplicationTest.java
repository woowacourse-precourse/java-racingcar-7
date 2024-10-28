package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
    void 유효한_양수_입력시_정수반환() {
        String input = "5";
        int result = Validator.trialCount(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 음수_입력시_예외발생() {
        String input = "-1";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.trialCount(input))
                .withMessage("이동 횟수는 양수여야 합니다.");
    }

    @Test
    void 영입력시_예외발생() {
        String input = "0";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.trialCount(input))
                .withMessage("이동 횟수는 양수여야 합니다.");
    }

    @Test
    void 잘못된_문자입력시_예외발생() {
        String input = "abc";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.trialCount(input))
                .withMessage("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
