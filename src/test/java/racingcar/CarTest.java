package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.AcceleratorService;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car 인스턴스 생성 테스트")
    void createCar() {
        Car car = Car.ofStartingPoint("car1");
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Car의 이동 기능 테스트")
    void moveCar_withAccelerator() {
        AcceleratorService accelerator = new AcceleratorService(() -> 5);
        Car car = Car.ofStartingPoint("car1");

        car.move(accelerator);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }
}
