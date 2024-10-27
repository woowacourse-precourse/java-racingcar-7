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

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi :", "woni :", "jun :", "최종 우승자 :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,abcdefg", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5글자 이하만 입력 가능합니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1번 이상은 시도해야합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
