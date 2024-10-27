package racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.DuplicateNameException;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        String[] initialCars = {"pobi", "woni", "crong"};
        cars.addCar(initialCars);
    }

    @Test
    void 중복_이름_예외_테스트() {
        // given
        String[] duplicateNames = {"pobi", "pobi"};

        // when & then
        assertThatThrownBy(() -> cars.addCar(duplicateNames))
                .isInstanceOf(DuplicateNameException.class);
    }

    @Test
    void 이동_테스트() {
        // when
        cars.moveForward();

        // then
        for (Car car : cars.getWinners()) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 우승자_반환_테스트() {
        // given
        cars.moveForward();
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).isNotEmpty();
    }
}
