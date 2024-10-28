package mock;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.Utils.MOVING_FORWARD;
import static util.Utils.STOP;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.policy.CarMovePolicy;
import racingcar.model.policy.MoveConditionPolicy;
import racingcar.model.policy.MovementPolicy;

class RacingGameTest extends NsTest {

    private MoveConditionPolicy moveConditionPolicy;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        moveConditionPolicy = new MockMoveConditionPolicy(
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );

        movementPolicy = new CarMovePolicy(
                moveConditionPolicy
        );
    }

    @Test
    void 자동차를_게임에_참여시킨다() {
        assertSimpleTest(() -> {
                    RacingGame racingGame = new RacingGame(movementPolicy, 1);
                    racingGame.join(List.of(
                            new Car("car1"),
                            new Car("car2"),
                            new Car("car3")
                    ));
                    assertThat(racingGame.getCurrentCarState()).hasSize(3);
                }
        );
    }

    @Test
    void 중복된_자동차를_참여시키면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                RacingGame racingGame = new RacingGame(movementPolicy, 1);
                racingGame.join(List.of(
                        new Car("car1"),
                        new Car("car1"),
                        new Car("car3")
                ));
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 정해진_시도횟수_보다_많이_시도하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                RacingGame racingGame = new RacingGame(movementPolicy, 1);
                racingGame.join(List.of(
                        new Car("car1"),
                        new Car("car2")
                ));
                racingGame.tryRound();
                racingGame.tryRound();
            }).isInstanceOf(IllegalStateException.class);
        });
    }

    @Test
    void 게임의_라운드를_진행한다() {
        assertSimpleTest(() -> {
                    RacingGame racingGame = new RacingGame(movementPolicy, 1);
                    racingGame.join(List.of(
                            new Car("car1"),
                            new Car("car2"),
                            new Car("car3")
                    ));
                    racingGame.tryRound();
                    List<Car> cars = racingGame.getCurrentCarState();
                    assertThat(cars.get(0).getPosition()).isZero();
                    assertThat(cars.get(1).getPosition()).isEqualTo(1);
                    assertThat(cars.get(2).getPosition()).isEqualTo(1);
                }
        );
    }

    @Test
    void 게임의_우승자를_조회한다() {
        RacingGame racingGame = new RacingGame(movementPolicy, 1);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        racingGame.join(List.of(
                car1,
                car2,
                car3
        ));
        racingGame.tryRound();
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).contains(car2, car3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
