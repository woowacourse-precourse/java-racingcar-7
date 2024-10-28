package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovementStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("우승자를 정확하게 판별한다")
    void findWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars cars = new Cars(List.of(car1, car2, car3));

        // car1과 car2만 전진
        car1.move(true);
        car2.move(true);

        List<Car> winners = cars.getWinners();
        assertThat(winners).hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car1", "car2");
    }

    @Test
    @DisplayName("우승자를 전략을 사용하여 판별한다")
    void findWinnersWithStrategy() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars cars = new Cars(List.of(car1, car2, car3));

        MovementStrategy alwaysMoveStrategy = () -> true;
        cars.moveAll(alwaysMoveStrategy);

        List<Car> winners = cars.getWinners();
        assertThat(winners).hasSize(3)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @Test
    @DisplayName("진행률을 정확하게 계산한다")
    void calculateProgress() {
        Car car = new Car("test");
        Cars cars = new Cars(List.of(car));

        car.move(true);  // 1칸 전진

        String progressBar = cars.getProgressBar();
        assertThat(progressBar).contains("100%")
                .contains("====================");
    }
}