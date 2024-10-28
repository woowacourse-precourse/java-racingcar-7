package racingcar.test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CustomApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    void 이동_횟수_변경_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : ");
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    void 이동_기록_출력_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 참가자_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_이후_참가자_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참가자_이름_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,choisiwon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_참가자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈값_참가자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,pboi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈값_참가자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
