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
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("참가 자동차가 1대인 경우")
    @Test
    void 기능_테스트_자동차1개() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("JB", "1");
                    assertThat(output()).contains("JB : -", "최종 우승자 : JB");
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

    @DisplayName("자동차 이름이 공백 일 때")
    @Test
    void 예외_테스트_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름의 쉼표 사이에 공백이 있을 때")
    @Test
    void 예외_테스트_쉼표사이공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A, ,B", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름의 쉼표가 2개 연속으로 있을 때")
    @Test
    void 예외_테스트_연속쉼표() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("A,,B", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("경주 횟수 입력이 양이 아닌 정수 일 때")
    @Test
    void 예외_테스트_양이아닌정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("경주 횟수 입력이 정수형이 아닐 때")
    @Test
    void 예외_테스트_not정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "three"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "3.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
