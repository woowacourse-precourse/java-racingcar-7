package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.view.Message;

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
    void 이름_초과테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,p123452", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_OVERNAME)
        );
    }

    @Test
    void 이름_미입력테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 이름_중복테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_미입력테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_EMPTYCOUNT)
        );
    }

    @Test
    void 횟수_음수테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_INVALIDCOUNT2)
        );
    }

    @Test
    void 횟수_소수점테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0.5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_INVALIDCOUNT1)
        );
    }

    @Test
    void 횟수_소수점테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "1.5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_INVALIDCOUNT1)
        );
    }

    @Test
    void 차량수테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ERROR_ONECAR)
        );
    }

    @Test
    void 특수문자테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po!b,wo>c", "1");
                    assertThat(output()).contains("po!b : -", "wo>c : ", "최종 우승자 : po!b");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 대량테스트() {
        StringBuilder cars = new StringBuilder();
        for (int i = 1; i <= 99; i++) {
            cars.append("po").append(i);
            if (i < 99) {
                cars.append(", ");
            }
        }
        assertRandomNumberInRangeTest(
                () -> {
                    run(cars.toString(), "100");
                    assertThat(output()).contains("po1 : ", "po2 : ", "최종 우승자 : "); // 특정 출력 내용 체크
                },
                MOVING_FORWARD, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});

    }
}
