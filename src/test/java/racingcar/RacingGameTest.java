package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import mock.ManualMockRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.policy.MovementPolicy;
import racingcar.model.policy.RandomForwardMovementPolicy;

class RacingGameTest extends NsTest {

    private static final RandomNumberGenerator mockRandomGenerator = new ManualMockRandomNumberGenerator(
            2,
            9,
            5
    );

    private static MovementPolicy movementPolicy = new RandomForwardMovementPolicy(
            mockRandomGenerator
    );

    @Test
    void 자동차를_게임에_참여시킨다() {
        assertSimpleTest(() -> {
                    RacingGame racingGame = new RacingGame(movementPolicy, 1);
                    racingGame.join(new Car("car1"));
                    racingGame.join(new Car("car2"));
                    racingGame.join(new Car("car3"));
                    assertThat(racingGame.getParticipants()).hasSize(3);
                }
        );
    }

    @Test
    void 게임의_라운드를_진행한다() {
        assertSimpleTest(() -> {
                    RacingGame racingGame = new RacingGame(movementPolicy, 1);
                    racingGame.join(new Car("car1"));
                    racingGame.join(new Car("car2"));
                    racingGame.join(new Car("car3"));
                    racingGame.playRound();
                    List<Car> cars = racingGame.getParticipants();
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
        racingGame.join(car1);
        racingGame.join(car2);
        racingGame.join(car3);
        racingGame.playRound();
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).contains(car2, car3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
