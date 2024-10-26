package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.service.RacingCarService;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 예외_테스트_입력공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차이름_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("CarA,,CarB", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자_결정_로직_테스트() {
        Cars cars = new Cars(Map.of("CarA", 5, "CarB", 4, "CarC", 2));
        RacingCarService service = new RacingCarService();
        List<String> winners = service.getWinners(cars);
        assertEquals(List.of("CarA"), winners);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
