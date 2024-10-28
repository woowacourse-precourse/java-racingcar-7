package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 게임_시작_기본_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
                    RacingGame game = new RacingGame(cars, 1);
                    game.start();
                    assertThat(output()).contains(
                            "실행 결과",
                            "pobi : -",
                            "crong : ",
                            "honux : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 우승자_판별_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
                    RacingGame game = new RacingGame(cars, 1);
                    game.start();
                    assertThat(output()).contains(
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
