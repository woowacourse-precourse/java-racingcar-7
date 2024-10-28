package racingcar.model.domain;

import org.junit.jupiter.api.Test;
import racingcar.model.infrastructure.Car;
import racingcar.model.infrastructure.CarMoveDecider;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void 거리반환테스트() {
        // given
        int distance = 1;
        String name = "name";
        CarMoveDecider carMoveDecider = CarMoveDecider.getInstance();
        Vehicle vehicle = new Car(name, distance, carMoveDecider);

        // when
        System.out.println("=====Logic Start=====");
        System.out.println("=====Logic End=====");
        // then
        assertThat(distance).isEqualTo(vehicle.getDistance());
    }
    @Test
    void 탈것명반환테스트() {
        int distance = 1;
        String name = "name";
        CarMoveDecider carMoveDecider = CarMoveDecider.getInstance();
        Vehicle vehicle = new Car(name, distance, carMoveDecider);

        // when
        System.out.println("=====Logic Start=====");
        System.out.println("=====Logic End=====");
        // then
        assertThat(vehicle.getName()).isEqualTo(name);

    }

}