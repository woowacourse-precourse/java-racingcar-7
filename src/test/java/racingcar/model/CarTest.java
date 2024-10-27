package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.move.MoveStrategy;

class CarTest {

    @DisplayName("자동차 이동 테스트")
    @Test
    void 자동차_이동_테스트() {
        //given
        MoveStrategy alwaysMoveStrategy = () -> true;
        MoveStrategy neverMoveStrategy = () -> false;
        Car moveCar = new Car("moveCar", alwaysMoveStrategy);
        Car stopCar = new Car("stopCar", neverMoveStrategy);

        // when
        moveCar.move();
        stopCar.move();

        // then
        assertEquals(1, moveCar.getPosition());
        assertEquals(0, stopCar.getPosition());
    }

}
