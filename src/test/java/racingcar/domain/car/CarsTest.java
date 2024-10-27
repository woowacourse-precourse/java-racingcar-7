package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 동점_승리자_확인() {
        List<String> carNames = List.of("labi", "lisa", "june");
        Cars cars = new Cars(carNames);

        cars.getCars().get(0).move();
        cars.getCars().get(2).move();

        List<Car> winners = cars.getWinners();

        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("labi", "june");
    }

    @Test
    void 단일_승리자_확인() {
        List<String> carNames = List.of("labi", "lisa", "june");
        Cars cars = new Cars(carNames);

        cars.getCars().get(0).move();
        cars.getCars().get(0).move();

        List<Car> winners = cars.getWinners();

        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("labi");
    }
}
