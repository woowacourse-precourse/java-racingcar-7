package racingcar;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        String name = "theo";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_테스트() {
        // given
        Car car = new Car("theo");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_여러번_이동_테스트() {
        // given
        Car car = new Car("theo");

        // when
        car.move();
        car.move();
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}