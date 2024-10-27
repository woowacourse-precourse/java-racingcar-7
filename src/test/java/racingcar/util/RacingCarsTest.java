package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import racingcar.model.Car;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;

public class RacingCarsTest {
    private List<Car> cars;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        // 초기 자동차 리스트
        car1 = new Car("pobi");
        car2 = new Car("crong");
        cars = List.of(car1, car2);
    }

    @Test
    @DisplayName("자동차가 이동 가능한 경우 모두 이동하는지 테스트")
    void carsCanMove() {
        // given (항상 이동 가능)
        FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);
        RacingCars racingCars = new RacingCars(cars, moveStrategy);

        // when
        racingCars.moveCars();

        // then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동 불가능한 경우 모두 정지하는지 테스트")
    void carsCanNotMove() {
        // given
        FixedMoveStrategy moveStrategy = new FixedMoveStrategy(false); // 항상 이동 불가능
        RacingCars racingCars = new RacingCars(cars, moveStrategy);

        // when
        racingCars.moveCars();

        // then
        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 리스트 가져오기 테스트")
    void carsList() {
        // given
        FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);
        RacingCars racingCars = new RacingCars(cars, moveStrategy);

        // when
        List<Car> retrievedCars = racingCars.getCars();

        // then
        assertThat(retrievedCars).containsExactly(car1, car2);
    }
}
