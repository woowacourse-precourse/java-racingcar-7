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
    void 자동차_이름_길이_5_이상_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_구분_없는_경우_예외_테스트(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon.rang", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon;rang", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_1회_미만_예외_테스트(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon,rang", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon,rang", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_빈_값인_경우_예외_테스트(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon,rang", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 시도_횟수_숫자_아닌_경우_예외_테스트(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon,rang", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_자동차_이름_있는_경우_예외_테스트(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("joon,joon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
