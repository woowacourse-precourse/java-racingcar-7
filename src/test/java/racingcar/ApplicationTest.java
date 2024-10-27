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
    void 차_이름에_양옆공백이_있을_시_trim_하고_작동한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("  pobi    ,   woni   ", "1");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    2,
                                    "pobi", "woni",
                                    "1", "0"
                            ),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"
                            )
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 라운드_양옆공백이_있을_시_trim_하고_작동한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1 ");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    2,
                                    "pobi", "woni",
                                    "1", "0"
                            ),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"
                            )
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_여러명일시_모든_우승자를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, hani", "2");
                    assertThat(output()).contains(
                            RacingCarResultUtil.generateIntermediateResultMessage(
                                    3,
                                    "pobi", "woni", "hani",
                                    "1", "0", "0",
                                    "1", "1", "0"
                            ),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi", "woni"
                            )
                    );
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
                                    "1", "0"
                            ),
                            RacingCarResultUtil.generateWinnerMessage(
                                    "pobi"
                            )
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
        );
    }

    @Test
    void 차량_글자수가_5글자가_넘을시_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java 1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름_파싱이_안될시_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름이_빈칸일시_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름이_중복되면_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani, pobi ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이름_중복검사_시_대소문자를_구분하지_않는다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani, POBI ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드가_음수일시_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani ", "-100"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_범위_초과할시_예외를_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hani ", "100000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_파싱이_안될시_예외를_발생한다() {
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
