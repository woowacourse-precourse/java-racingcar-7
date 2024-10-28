package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 이름, 시도할 횟수 모두 유효한 값 입력")
    void inputValidRacingCarNamesAndTryingCount() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름 5자 초과한 값 입력")
    void inputOver5lettersRacingCarNames() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    @DisplayName("예외: 자동차 이름 쉼표로 구분 불가")
    void CannotSeparateComma() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi;javaj", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    @DisplayName("예외: 시도 횟수에 숫자가 아닌 값 입력 입력")
    void inputNotNumberTryingCount() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaj", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
