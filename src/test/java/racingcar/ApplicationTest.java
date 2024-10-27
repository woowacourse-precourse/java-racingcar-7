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
    void 자동차_여러대_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("하나,둘,셋,넷,다섯,여섯,일곱,여덟,아홉,열", "1");
                assertThat(output()).contains("하나 : ", "둘 : ","셋 : ","넷 : ","다섯 : ","여섯 : -","일곱 : ","여덟 : ","아홉 : ","열 : ", "최종 우승자 : 여섯");
            },
            STOP,STOP,STOP,STOP,STOP,MOVING_FORWARD,STOP,STOP,STOP,STOP
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
    void 잘못된_자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("하나,두우우우우울", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 공백이거나 5자를 초과하였습니다.")
        );
    }

    @Test
    void 음수값_시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("하나,five", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수로 입력하시기 바랍니다.")
        );
    }

    @Test
    void 숫자가_아닌_시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("one,three", "two"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력하시기 바랍니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
