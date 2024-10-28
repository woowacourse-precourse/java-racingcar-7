package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.MaxValueIntGeneratorStrategy;

public class CarsTest {

    @Test
    void Given_Cars_객체_생성_When_호출시_Expect_Car_객체_리스트를_반환한다() {
        final List<String> carNames = Arrays.asList("car1", "car2", "car3");
        final Cars cars = new Cars(carNames, new RandomIntGeneratorStrategy());

        List<Car> expectedCars = Arrays.asList(
                new Car("car1", new RandomIntGeneratorStrategy()),
                new Car("car2", new RandomIntGeneratorStrategy()),
                new Car("car3", new RandomIntGeneratorStrategy())
        );

        assertThat(cars.getCars()).hasSize(carNames.size());
        assertThat(cars.getCars()).extracting("carName").containsExactlyInAnyOrder("car1", "car2", "car3");
        assertThat(cars.getCars()).usingRecursiveComparison().isEqualTo(expectedCars);
    }

    @Test
    void Given_Car_객체_리스트_When_호출시_Expect_제일_먼_거리에_있는_자동차_위치를_반환한다() {
        final List<String> carNames = Arrays.asList("car1", "car2", "car3");
        final Cars cars = new Cars(carNames, new MaxValueIntGeneratorStrategy());

        cars.requestCarMove();

        assertThat(cars.getCars().get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isGreaterThanOrEqualTo(0);

        int longestPosition = cars.getLongestPosition();
        assertThat(longestPosition).isGreaterThanOrEqualTo(0);
    }
}