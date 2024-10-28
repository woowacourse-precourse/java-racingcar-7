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
    void 쉼표만_입력한_경우_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 아무것도_입력하지_않은_경우_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백만_입력한_경우_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_이름을_입력한_경우_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"," "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈문자열_에러() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi",""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_값이_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,migi","fds"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_0이하의_값을_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,fds","-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
