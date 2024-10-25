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

    @DisplayName("자동차 이름이 6이상의 문자열이라면 IllegalException Throw")
    @Test
    void 자동차_이름_6이상_일시_에러_발생() {
        assertThatThrownBy(() -> runException("soonhong"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수 문자열이 숫자가 아닌 다른 문자가 왔을 경우")
    @Test
    void 시도_횟수로_숫자가_안왔을_경우_에러_발생() {
        assertThatThrownBy(() -> runException("soon,hong", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 0이하일 경우")
    @Test
    void 시도_횟수가_0이하일_경우_에러_발생() {
        assertThatThrownBy(() -> runException("soon,hong", "-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
