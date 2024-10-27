package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("test"));
    }

    @Test
    @DisplayName("이름이 정상적으로 출력되어야 한다")
    void testGetName() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("입력한 수만큼 위치 값이 더해져야한다")
    void testForward() {
        car.forward(1);
        assertThat(car.toString()).isEqualTo("test : -");
        car.forward(0);
        assertThat(car.toString()).isEqualTo("test : -");
    }

    @Test
    @DisplayName("입력 값의 위치보다 앞에 있다면 true, 아니면 false")
    void testIsMoreFar() {
        Car otherCar = new Car(new Name("other"));
        car.forward(1);
        assertThat(car.isMoreFar(otherCar)).isEqualTo(true);

        otherCar.forward(2);
        assertThat(car.isMoreFar(otherCar)).isEqualTo(false);
    }

    @Test
    @DisplayName("입력 값과 위치가 같다면 true, 아니면 false")
    void testIsSamePosition() {
        Car otherCar = new Car(new Name("other"));
        assertThat(car.isSamePosition(otherCar)).isEqualTo(true);

        car.forward(1);
        assertThat(car.isSamePosition(otherCar)).isEqualTo(false);
    }
}
