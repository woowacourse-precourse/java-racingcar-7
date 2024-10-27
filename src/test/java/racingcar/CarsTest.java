package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.MovementStrategy;

public class CarsTest {
    @Test
    @DisplayName("자동차가 모두 이동하면 거리가 증가한다")
    void allMoveCars() {
        List<Car> carList = Arrays.asList(Car.from(CarName.from("kiri")), Car.from(CarName.from("alice")));
        Cars cars = Cars.from(carList);
        for (Car car : carList) {
            car.move(()->true);
        }
        assertThat(cars.fetchCarsPositions()).containsExactly(1,1);
    }


}
