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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는 경우")
    void 이름_공백_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, , woni", "5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("0번 입력 시")
    void 시도횟수_0번일때() {
        assertSimpleTest(
                () -> {
                    run(" pobi,woni ", "0");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                }
        );
    }

    @Test
    @DisplayName("시도횟수 \\n 입력시")
    void 시도횟수_엔터일때() {
        assertSimpleTest(
                () -> {
                    run(" pobi,woni ", "\n");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                }
        );
    }



}
