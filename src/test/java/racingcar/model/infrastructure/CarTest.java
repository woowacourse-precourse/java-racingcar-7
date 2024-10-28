package racingcar.model.infrastructure;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    @Test
    void 자동차가_움직였을때_검증테스트() {
        // given
        int raceScore = 4;
        int distance = 1;
        String name = "name";
        CarMoveDecider carMoveDecider = CarMoveDecider.getInstance();
        Vehicle vehicle = new Car(name, distance, carMoveDecider);

        // when
        System.out.println("=====Logic Start=====");

        boolean move = vehicle.move(raceScore);

        System.out.println("=====Logic End=====");
        // then
        assertAll(() -> assertThat(move).isTrue(),
                () -> assertThat(vehicle.getDistance()).isEqualTo(2));

    }

    @Test
    void 자동차가_움직이지_않았을때_검증테스트() {
        // given
        int raceScore = 3;
        int distance = 1;
        String name = "name";
        CarMoveDecider carMoveDecider = CarMoveDecider.getInstance();
        Vehicle vehicle = new Car(name, distance, carMoveDecider);

        // when
        System.out.println("=====Logic Start=====");

        boolean move = vehicle.move(raceScore);

        System.out.println("=====Logic End=====");
        // then
        assertAll(() -> assertThat(move).isFalse(),
                () -> assertThat(vehicle.getDistance()).isOne());

    }
}