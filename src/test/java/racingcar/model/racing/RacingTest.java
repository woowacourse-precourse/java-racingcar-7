package racingcar.model.racing;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.Car;
import racingcar.model.car.strategy.MoveBehavior;
import racingcar.model.car.strategy.RandomMove;

@DisplayName("경주 관련 테스트")
class RacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private List<Car> cars;
    private MoveBehavior moveBehavior;

    @BeforeEach
    void setUp() {
        moveBehavior = new RandomMove();
        cars = List.of(
                new Car(moveBehavior, "car1"),
                new Car(moveBehavior, "car2"),
                new Car(moveBehavior, "car3")
        );
    }

    @Test
    public void 라운드_진행_횟수_만큼_실행() {
        // given
        int roundsToRace = 37;
        Racing racing = Racing.from(cars, roundsToRace);

        // when
        int executed = 0;
        while (racing.hasNextRound()) {
            racing.executeRound();
            executed++;
        }

        // then
        Assertions.assertThat(executed).isEqualTo(roundsToRace);
    }

    @Test
    public void 우승자_추출_테스트() {
        // given
        Racing racing = Racing.from(cars, 1);

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    while (racing.hasNextRound()) {
                        racing.executeRound();
                    }

                    // when
                    List<Car> winners = racing.getWinners();

                    // then
                    Assertions.assertThat(winners)
                            .hasSize(2)
                            .extracting(Car::getName)
                            .contains("car1", "car2");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    public void 라운드_진행횟수_범위_초과_또는_미만시_예외_발생() {
        // given
        int lower = 0;
        int upper = 101;

        // when, then
        Assertions.assertThatThrownBy(() -> Racing.from(cars, lower))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.RACE_ROUND_OUT_OF_BOUND.getMessage());

        Assertions.assertThatThrownBy(() -> Racing.from(cars, upper))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.RACE_ROUND_OUT_OF_BOUND.getMessage());
    }
}
