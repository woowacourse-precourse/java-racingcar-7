package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    @Test
    @DisplayName("차가 이동한다")
    void move(){
        Car car = Car.of("kiri");
        car.move(()-> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}

