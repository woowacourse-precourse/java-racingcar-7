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
    void carNameStripTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run(" blank, test  ", "1");
                assertThat(output()).contains("blank : -", "test : -", "최종 우승자 : blank, test");
            },
            MOVING_FORWARD, MOVING_FORWARD
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
    void carNamesInputBlankTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void carNameBlankTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("blank,   ,test"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void carNameDuplicatedTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("dup,dup"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void carMoveCountInvalidValueTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("inval,value", "test"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void carMoveCountZeroOrLessTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("under,zero", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void carMoveCountMoreThan80Test() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("under,zero", "81"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
