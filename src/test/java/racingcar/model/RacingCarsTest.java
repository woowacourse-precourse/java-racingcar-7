package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.FakeMovementFactorGenerator;

class RacingCarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 이름으로 자동차들을 생성할 수 있다.")
    @Test
    void createCars() {
        // given
        List<String> names = List.of("a", "b", "c");

        // when
        RacingCars racingCars = RacingCars.of(names, new RandomMovementFactorGenerator());

        // then
        List<RacingCar> cars = racingCars.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting("name")
                .containsExactlyInAnyOrder("a", "b", "c");
    }

    @DisplayName("중복된 이름을 가진 자동차가 있으면 예외가 발생한다.")
    @Test
    void createCarsWithDuplicateName() {
        // given
        List<String> names = List.of("a", "b", "a");

        // when
        assertThatThrownBy(() -> RacingCars.of(names, new RandomMovementFactorGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("레이스를 진행하면 각 자동차의 위치를 확인할 수 있다.")
    @Test
    void race() {
        // given
        List<String> names = List.of("a", "b");
        FakeMovementFactorGenerator movementFactorGenerator = new FakeMovementFactorGenerator(
                List.of(MOVING_FORWARD, STOP)
        );
        RacingCars racingCars = RacingCars.of(names, movementFactorGenerator);

        // when
        List<RacingCarSnapShot> racingCarSnapShots = racingCars.race();

        // then
        assertThat(racingCarSnapShots).hasSize(2)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("a", 1),
                        tuple("b", 0)
                );
    }

    @DisplayName("가장 먼 위치에 있는 자동차가 우승한다.")
    @Test
    void getWinners() {
        // given
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("car1", 1),
                new RacingCar("car2", 0),
                new RacingCar("car3", 1)
        ), new RandomMovementFactorGenerator());

        // when
        List<String> winners = racingCars.getWinners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("car1", "car3");
    }

}
