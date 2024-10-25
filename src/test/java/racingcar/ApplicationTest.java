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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_차_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 모두_이동_실패() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,asd", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "asd : ", "최종 우승자 : pobi, woni, asd");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 이름_띄어쓰기_허용() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po bi,woni", "1");
                    assertThat(output()).contains("po bi : -", "woni : ", "최종 우승자 : po bi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
