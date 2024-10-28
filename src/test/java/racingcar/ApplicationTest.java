package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다")
        );
    }

    @Test
    void 이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 자동차 이름이 있습니다")
        );
    }

    @Test
    void 빈_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 비어있을 수 없습니다")
        );
    }

    @Test
    void 시도_횟수_0_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다")
        );
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다")
        );
    }

    @Test
    void 시도_횟수_문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 숫자여야 합니다")
        );
    }

    @Test
    void 여러_라운드_진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains(
                            "실행 결과",
                            "pobi : -",
                            "woni : -"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "최종 우승자 : pobi, woni"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}