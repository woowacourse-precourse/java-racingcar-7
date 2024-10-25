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
    void 차_이름_trim_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("  pobi    ,   woni   ", "1");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    2,
                                    "pobi", "woni",
                                    "1", "0"),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"));
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 라운드_trim_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1 ");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    2,
                                    "pobi", "woni",
                                    "1", "0"),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"));
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, hani", "2");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    3,
                                    "pobi", "woni", "hani",
                                    "1", "0", "0",
                                    "1", "1", "0"),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi", "woni"
                            ));
                },
                MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    2,
                                    "pobi", "woni",
                                    "1", "0"),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"));
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
    void 차량_글자수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java 1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름_파싱_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름_빈칸_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani, pobi ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani ", "-100"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_범위_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani ", "100000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_파싱_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani ", "notRound"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
