package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
    }
    
    @Test
    @DisplayName("Car 초기화")
    void carCreateTest() {
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 후 출력")
    void moveCarTest() {
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        Assertions.assertThat(car.toString()).isEqualTo("pobi : -");
    }
}