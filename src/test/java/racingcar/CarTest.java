package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarName;

public class CarTest {
    @Test
    @DisplayName("차가 이동한다")
    void move(){
        Car car = Car.from(CarName.from("kiri"));
        car.move(()-> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 정지한다")
    void stop(){
        Car car = Car.from(CarName.from("kiri"));
        car.move(()-> false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

}

