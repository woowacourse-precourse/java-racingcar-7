package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static race.CheckException.checkIsStart;

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
    void 기능_테스트_2명_이상의_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,john", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "john : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트_자동차이름_빈문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_빈문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 에외_테스트_모든_자동차_진전x() {
        // 두 자동차가 모두 정지 상태인 경우를 가정한 데이터
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 0);

        // 전진 여부를 검사하고, 예외가 발생하는지 확인
        assertThatThrownBy(() -> {
            checkIsStart(cars);  // 자동차의 전진 여부 검사
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_시도횟수_시도횟수_0인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_음수인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_하나의_자동차() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
