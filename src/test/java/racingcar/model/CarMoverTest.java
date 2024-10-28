package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarMoverTest {
    private CarMover carMover;

    @BeforeEach
    void setUp() {
        carMover = new CarMover();
    }

    @Test
    void 여러_자동차_전진() {
        // given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));

        // when & then
        Assertions.assertRandomNumberInRangeTest(
                () -> carMover.moveCars(carList),
                4,
                4, 5, 6, 7, 8, 9
        );

        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 여러_자동차_멈춤() {
        //given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));

        // when & then
        Assertions.assertRandomNumberInRangeTest(
                () -> carMover.moveCars(carList),
                3,
                0, 1, 2, 3
        );

        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    void 자동차_위치_확인() {
        // given
        List<Car> carList = List.of(new Car("car1"));

        // when & then
        Assertions.assertRandomNumberInRangeTest(
                () -> carMover.moveCars(carList),
                4,
                4, 5, 6, 7, 8, 9
        );

        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 여러번_전진() {
        //given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));
        int roundNumber = 5;

        //when
        for (int i = 0; i < roundNumber; i++) {
            Assertions.assertRandomNumberInRangeTest(
                    () -> carMover.moveCars(carList),
                    4,
                    4, 5, 6, 7, 8, 9
            );
        }

        //then
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(roundNumber);
        }
    }
}