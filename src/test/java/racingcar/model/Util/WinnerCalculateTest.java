package racingcar.model.Util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car.Car;
import racingcar.model.Util.WinnerCalculate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCalculateTest {

    private WinnerCalculate winnerCalculate;

    @BeforeEach
    void setUp() {
        winnerCalculate = new WinnerCalculate();
    }

    @Test
    void 우승자가_한_명인_경우_확인() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 5),  // 최고 이동 횟수를 가진 유일한 우승자
                new Car("car3", 4)
        );

        List<Car> winners = winnerCalculate.winnerCars(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("car2");
    }

    @Test
    void 우승자가_여러_명인_경우_확인() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 5),
                new Car("car2", 3),
                new Car("car3", 5),  // car1과 car3이 동일한 최고 이동 횟수를 가짐
                new Car("car4", 2)
        );

        List<Car> winners = winnerCalculate.winnerCars(cars);

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("car1", "car3");
    }

    @Test
    void 모든_자동차의_이동_횟수가_같은_경우_확인() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 4),
                new Car("car2", 4),
                new Car("car3", 4)
        );

        List<Car> winners = winnerCalculate.winnerCars(cars);

        assertThat(winners).hasSize(3);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @Test
    void 이동_횟수가_0인_자동차만_있는_경우_확인() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );

        List<Car> winners = winnerCalculate.winnerCars(cars);

        assertThat(winners).hasSize(3);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("car1", "car2", "car3");
    }
}