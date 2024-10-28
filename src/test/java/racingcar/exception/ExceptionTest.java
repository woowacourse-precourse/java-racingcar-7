package racingcar.exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ExceptionTest extends NsTest {
    @Test
    @DisplayName("이름이 6이상인 테스트")
    void nameOver6Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeongg,hun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 사이에 공백 테스트")
    void spaceInBetweenNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeong, ,hun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 사이에 빈칸 테스트")
    void blankInBetweenNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeong,,hun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 횟수가 숫자가 아닐 때 테스트")
    void noDigitTryNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeong,hun", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 횟수가 0일 때 테스트")
    void tryNumberEqualZeroTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeong,hun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 횟수가 음수일 때 테스트")
    void tryNumberLessThenOneTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jeong,hun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
