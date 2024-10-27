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

    @Test
    void 예외_테스트_이름_공백_구분() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_이름_다른_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;woni;jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
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
    void 예외_테스트_빈_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수가_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_비숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -");
                },
                MOVING_FORWARD // 무작위 값이 4 이상이므로 이동
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : ");
                },
                STOP // 무작위 값이 3 이하여서 멈춤
        );
    }

    @Test
    void 최대_위치_우승자_결정_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output())
                            .contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD // pobi가 가장 멀리 이동함
        );
    }

    @Test
    void 여러명_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output())
                            .contains("최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD // pobi와 jun이 동일한 거리로 이동
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
