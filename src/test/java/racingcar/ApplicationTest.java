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
    void 이름사이에공백넣기() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("p o b i,     w   o n  i", "1");
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
    void 숫자대신문자넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 처음에빈문자열넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 중간에빈문자열넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 매우_큰_실행횟수 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }







    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
