package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    void getCarName_테스트() {
        Car car = new Car("car");
        assertThat(car.getCarName()).isEqualTo("car");
    }

    @Test
    void getPosition_테스트(){
        Car car = new Car("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getCurrentPositionString_테스트(){
        Car car = new Car("car");
        assertThat(car.getCurrentPositionString()).isEqualTo("");
    }

    @Test
    void moveForward_테스트(){
        Car car = new Car("car");
        car.moveForward();
        assertThat(car.getCurrentPositionString()).isEqualTo("-");
    }

}
