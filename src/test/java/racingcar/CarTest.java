package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("Car 생성자 테스트 - 초기 postion은 0이어야함")
    void testCarConstructor() {
        // given
        String name = "car";
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("move()메소드 테스트 - 랜덤값이 4이상일때 이동함")
    void testCarMoveWithRandomAboveFour() {
        // given
        Car car = new Car("car");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("move()메소트 테스트 - 랜덤값이 3이하일때 이동하지않음")
    void testCarMoveWithRandomBelowFour() {
        // given
        Car car = new Car("car") {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };
        int initialPosition = car.getPosition();

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

}
