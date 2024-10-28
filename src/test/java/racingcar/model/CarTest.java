package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.strategy.IntGeneratorStrategy;
import racingcar.model.strategy.MaxValueIntGeneratorStrategy;
import racingcar.model.strategy.MinValueIntGeneratorStrategy;

public class CarTest {

    @Test
    void Given_최댓값_숫자_생성기_When_생성자_호출시_Expect_자동차_객체가_생성된다() {
        final IntGeneratorStrategy randomIntGeneratorStrategy = new RandomIntGeneratorStrategy();
        final String carName = "car1";
        final Car car = new Car(carName, randomIntGeneratorStrategy);

        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @Test
    void Given_최댓값_숫자_생성기_When_tryMove_호출시_Expect_자동차가_이동한다() {
        final IntGeneratorStrategy maxValueIntGeneratorStrategy = new MaxValueIntGeneratorStrategy();
        final String carName1 = "car1";
        final Car car1 = new Car(carName1, maxValueIntGeneratorStrategy);

        car1.tryMove();

        assertThat(car1.getPosition()).isEqualTo(1);

        final IntGeneratorStrategy minValueIntGeneratorStrategy = new MinValueIntGeneratorStrategy();
        final String carName2 = "car2";
        final Car car2 = new Car(carName2, minValueIntGeneratorStrategy);

        car2.tryMove();

        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
