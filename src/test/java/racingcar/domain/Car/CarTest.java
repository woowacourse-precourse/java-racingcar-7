package racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.randomnumber.RandomIntegerGenerator;
import racingcar.exceptions.InvalidNameException;

public class CarTest {
    private final RandomIntegerGenerator forwardGenerator = new RandomIntegerGenerator(4, 9);
    private final RandomIntegerGenerator stopGenerator = new RandomIntegerGenerator(0, 3);

    @Test
    void 초기화_테스트() {
        // given & when
        Car car = new Car(new Name("pobi"));

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름_예외_테스트() {
        // when & then
        assertThatThrownBy(() -> new Car(new Name("")))
                .isInstanceOf(InvalidNameException.class);

        assertThatThrownBy(() -> new Car(new Name("cheche903")))
                .isInstanceOf(InvalidNameException.class);
    }

    @Test
    void 움직임_테스트() {
        // given
        Car car = new Car(new Name("pobi"));

        // when
        car.moveForward(forwardGenerator);
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(1);
    }

    @Test
    void 정지_테스트() {
        // given
        Car car = new Car(new Name("pobi"));

        // when
        car.moveForward(stopGenerator);
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(0);
    }
}
