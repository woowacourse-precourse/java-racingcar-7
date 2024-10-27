package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 자동차_이름_검증() {
        assertThatThrownBy(() -> new Car("길이가_6초과"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_검증() {
        assertThatThrownBy(() -> new RacingGame(List.of(new Car("pobi")), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승자_선정_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(4);
        car2.move(5);

        RacingGame game = new RacingGame(List.of(car1, car2), 1);
        List<String> winners = game.getWinners();

        assertThat(winners).contains("pobi", "woni");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
