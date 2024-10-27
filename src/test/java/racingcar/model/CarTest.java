package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 객체를 생성할 수 있다.")
    void createCar() {
        // given, when
        Name name = new Name("우테코");
        Car car = new Car(name);

        // then
        Assertions.assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("동등한 Name을 지닌 자동차 객체는 동등성을 보장받는다.")
    void equalsCar() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("우테코");
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        // when, then
        Assertions.assertThat(car1).isEqualTo(car2);
    }

    @Test
    @DisplayName("자동차 객체를 이동시킨다.")
    void moveCar() {
        // given
        Name name = new Name("우테코");
        Car car = new Car(name);

        // when
        car.move(true);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("자동차 객체의 위치를 비교할 수 있다.")
    void comparePosition() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        // when
        car1.move(true);

        // then
        Assertions.assertThat(car1.hasBiggerPositionThan(car2)).isTrue();
    }
}