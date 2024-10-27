package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void createCar_ValidName_ShouldCreateCar() {
        Car car = new Car("CarA");
        assertThat(car.getName()).isEqualTo("CarA");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void createCar_InvalidName_ShouldThrowException() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값이 될 수 없습니다.");

        assertThatThrownBy(() -> new Car("LongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 5자까지 가능합니다.");
    }

    @Test
    public void moveForward_ShouldIncreasePosition() {
        Car car = new Car("CarA");
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}