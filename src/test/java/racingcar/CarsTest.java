package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

public class CarsTest {
    @Test
    @DisplayName("자동차가 모두 이동하면 거리가 증가한다")
    void allMoveCars() {
        List<Car> carList = Arrays.asList(Car.from(CarName.from("kiri")), Car.from(CarName.from("alice")));
        Cars cars = Cars.from(carList);
        for (Car car : carList) {
            car.move(() -> true);
        }
        assertThat(cars.fetchCarsPositions()).containsExactly(1, 1);
    }

    @Test
    @DisplayName("자동차들중 최대거리를 찾는다")
    void findMaxDistance() {
        List<Car> carList = Arrays.asList(
                Car.from(CarName.from("kiri")),
                Car.from(CarName.from("alice")),
                Car.from(CarName.from("bob")),
                Car.from(CarName.from("ash"))
        );
        Cars cars = Cars.from(carList);

        carList.get(0).move(() -> true);
        carList.get(1).move(() -> true);
        carList.get(1).move(() -> true);
        carList.get(2).move(() -> false);

        int maxDistance = cars.findRaceWinners().stream()
                .map(name -> cars.fetchCarsPositions().get(cars.fetchCarNames().indexOf(name)))
                .max(Integer::compare)
                .orElse(0);

        assertThat(maxDistance).isEqualTo(2);
    }

    @Test
    @DisplayName("승자를 정확히 찾는다")
    void findWinners() {
        List<Car> carList = Arrays.asList(
                Car.from(CarName.from("kiri")),
                Car.from(CarName.from("bob")),
                Car.from(CarName.from("alice"))
        );
        Cars cars = Cars.from(carList);

        carList.get(0).move(() -> true);
        carList.get(1).move(() -> true);
        carList.get(1).move(() -> true);
        carList.get(2).move(() -> false);

        List<String> winners = cars.findRaceWinners();
        assertThat(winners).containsExactly("bob");
    }

    @Test
    @DisplayName("중복된 자동차 이름으로 Cars 객체를 생성하려 하면 예외가 발생한다")
    void createCarsWithDuplicateNames() {
        List<Car> carList = Arrays.asList(
                Car.from(CarName.from("kiri")),
                Car.from(CarName.from("kiri")),
                Car.from(CarName.from("alice"))
        );

        assertThatThrownBy(() -> Cars.from(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
