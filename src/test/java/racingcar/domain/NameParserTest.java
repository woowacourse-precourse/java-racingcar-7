package racingcar.domain;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.Application;

public class NameParserTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름을_한_개만_입력한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_사이에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po bi,woni", "1");
                    assertThat(output()).contains("po bi : -", "woni : ", "최종 우승자 : po bi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_사이에_특수문자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po$bi,woni", "1");
                    assertThat(output()).contains("po$bi : -", "woni : ", "최종 우승자 : po$bi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_숫자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("12po,34bi", "1");
                    assertThat(output()).contains("12po : -", "34bi : ", "최종 우승자 : 12po");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름과_이름_사이에_구분자와_공백_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름과_이름_사이에_구분자와_공백_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi ,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 구분자로_입력을_마친다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,wonini", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}