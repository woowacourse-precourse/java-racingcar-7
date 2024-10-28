package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("Car Name이 일치해야한다")
    void checkCarName() {
        assertThat(car.getName().toString()).isEqualTo("test");
    }

    @Test
    @DisplayName("Car Position이 일치해야한다")
    void checkCarPosition(){
        car.move();
        car.move();
        assertThat(car.getPosition().getValue()).isEqualTo(2);
    }
}
