package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("생성자를 이용하여 Car 객체를 생성할 수 있다.")
    void createCarByConstructor() {
        Car car = new Car("pobi");
        assertThat(car.getCurrentStatus()).isEqualTo("pobi : \n");
    }

    @Test
    @DisplayName("자동차는 메서드를 통해 앞으로 전진한다.")
    void movePositionByMethod() {
        Car car = new Car("woni");
        car.moveForward(true);
        car.moveForward(false);
        car.moveForward(true);
        assertThat(car.getCurrentStatus()).isEqualTo("woni : --\n");
    }

    @Test
    @DisplayName("두 차량의 위치가 같을 경우 메서드는 참을 반환한다.")
    void compareTwoCarsPositionNotThrowException() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");

        pobiCar.moveForward(true);
        pobiCar.moveForward(true);
        woniCar.moveForward(true);
        woniCar.moveForward(true);

        assertThat(pobiCar.isCarSamePosition(woniCar)).isEqualTo(true);
    }

    @Test
    @DisplayName("두 차량의 위치가 다를 경우 메서드는 거짓을 반환한다.")
    void compareTwoCarsPositionThrowException() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");

        pobiCar.moveForward(true);
        pobiCar.moveForward(true);
        pobiCar.moveForward(true);

        assertThat(pobiCar.isCarSamePosition(woniCar)).isEqualTo(false);
    }
}
