package racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exceptions.InvalidNameException;

public class CarTest {

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
        car.moveForward();
        int position = car.getPosition();

        // then
        assertThat(position).isGreaterThanOrEqualTo(0);
    }
}
