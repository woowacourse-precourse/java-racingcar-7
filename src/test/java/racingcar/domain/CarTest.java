package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.moving.MovingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("car1");
    }

    @Test
    @DisplayName("aaa")
    void 전진_성공(){
        //given
        MovingStrategy movingStrategy = () -> true;
        int initialPosition = car.getPositionDistance();

        //when
        car.move(movingStrategy);

        //then
        assertEquals(initialPosition + 1, car.getPositionDistance());
    }

    @Test
    @DisplayName("asd")
    void 전진_실패(){
        //given
        MovingStrategy movingStrategy = () -> false;
        int initialPosition = car.getPositionDistance();

        //when
        car.move(movingStrategy);

        //then
        assertEquals(initialPosition, car.getPositionDistance());
    }

}
