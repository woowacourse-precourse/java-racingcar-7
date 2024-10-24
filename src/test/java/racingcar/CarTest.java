package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("TestCar");
    }

    @Test
    void 생성_확인_테스트() {
        assertThat(car.getName()).isEqualTo("TestCar");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void move_메서드_테스트() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void toString_메서드_테스트() {
        assertThat(car.toString()).isEqualTo("TestCar : ");

        car.move();
        assertThat(car.toString()).isEqualTo("TestCar : -");

        car.move();
        assertThat(car.toString()).isEqualTo("TestCar : --");
    }

}
