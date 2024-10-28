package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 복수_우승자_통합_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("cool, seani", "2");
                    assertThat(output()).contains("cool : --", "seani : --", "최종 우승자 : cool, seani");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
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
    void 자동차_이름_길이_초과_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cool,seaniiii", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복_예외_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cool,cool", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_입력_예외_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_문자열_입력_예외_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("  ,   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_음수_예외_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cool,sean", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_타입_예외_통합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("cool,sean", "몇번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
