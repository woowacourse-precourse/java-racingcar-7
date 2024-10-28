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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 복수_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,honux", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "honux : -", "최종 우승자 : pobi,woni,honux");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Test
    void 공백입력_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run(",,,", "1");
                    assertThat(output()).contains("car1 : -", "car2 : -", "car3 : -", "최종 우승자 : car1,car2,car3");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );

    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
