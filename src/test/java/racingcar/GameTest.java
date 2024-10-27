package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 여러_게임_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "4");
                assertThat(output()).contains("pobi : ---", "woni : -","jun : ---", "최종 우승자 : pobi, jun");
            },
            7, 3,9,4,3,6,3,4,1,7,3,6
        );
    }

    @Test
    void 이름_앞뒤에_공백_제거() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,  woni ,j V4", "4");
                    assertThat(output()).contains("pobi : ---", "woni : -","j V4 : ---", "최종 우승자 : pobi, j V4");
                },
                7, 3,9,4,3,6,3,4,1,7,3,6
        );
    }

    @Test
    void 자동차가_한대_입력됨() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_입력되지_않음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_공백만_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_특수문자_사용_불가() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!,test", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임_진행_횟수_0이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test2", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수형_범위를_벗어난_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("test1,test2", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
