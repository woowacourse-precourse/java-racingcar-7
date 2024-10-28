package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 자동차_이름_중복_예외_테스트() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "woni");
        assertThatThrownBy(() -> CarValidator.validateUniqueNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_이름_길이_초과_예외_테스트() {
        String invalidName = "abcdefgh"; // 이름 길이 5자 초과
        assertThatThrownBy(() -> CarValidator.validateName(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        int invalidAttempts = -3; // 음수 값

        assertThatThrownBy(() -> racingcar.validator.RaceValidator.validateAttempts(invalidAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
