package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        //given
        CarName carName = new CarName("test");
        Car car = new Car(carName);

        //when
        car.forward();

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차를_출력했을_때_이름과_이동거리가_포함된다() {
        //given
        CarName carName = new CarName("test");
        Car car = new Car(carName);

        //when
        car.forward();
        final String output = car.toString();

        //then
        Assertions.assertThat(output).isEqualTo(carName.getContent() + " : " + "-".repeat(car.getDistance()));
    }
}
