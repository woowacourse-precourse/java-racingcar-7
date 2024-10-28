package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.Car;
import racingcar.model.dto.RacingResult;
import racingcar.model.service.RacingService;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

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
    void play_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(new Car("pobi", 0), new Car("woni", 0));
                    RacingService racingService = new RacingService();
                    List<RacingResult> results = racingService.play(cars, 2);

                    assertThat(results.get(0).getCars()).extracting("name", "moveCount")
                            .containsExactlyInAnyOrder(
                                    tuple("pobi", 2),
                                    tuple("woni", 1)
                            );
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void getPlayWinner_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(new Car("pobi", 0), new Car("woni", 0));
                    RacingService racingService = new RacingService();
                    racingService.play(cars, 1);

                    String winner = racingService.getPlayWinner();
                    assertThat(winner).isEqualTo("pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void playAttemptCount_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(new Car("pobi", 0), new Car("woni", 0));
                    RacingService racingService = new RacingService();
                    racingService.playAttemptCount(cars);

                    assertThat(cars).extracting("name", "moveCount")
                            .containsExactlyInAnyOrder(
                                    tuple("pobi", 1),
                                    tuple("woni", 0)
                            );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
