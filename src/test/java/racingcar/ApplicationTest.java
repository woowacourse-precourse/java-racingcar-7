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
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 참가자한명_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi", "1");
                assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
            },
            MOVING_FORWARD
        );
    }

    @Test
    void 이름5자이상_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한글처리_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,짱구", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi;jun.hei", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수문자_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,hei", "hana"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
