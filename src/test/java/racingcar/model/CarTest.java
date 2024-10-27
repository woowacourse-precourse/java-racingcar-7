package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car = new Car("pobi");

    @DisplayName("Car_생성_테스트")
    @Test
    public void newCarTest() {
        //given
        //when
        //then
        assertNotNull(car);
    }

    @DisplayName("Car_이름_조회_테스트")
    @Test
    public void getNameTest() {
        //given
        //when
        String carName = car.getName();
        //then
        assertEquals("pobi", carName);
    }

    @DisplayName("Car_이동_테스트")
    @Test
    public void canMoveUsingTest() {
        //given
        //when
        boolean moveResult = car.canMoveUsing(4);
        boolean stopResult = car.canMoveUsing(3);
        //then
        assertTrue(moveResult);
        assertFalse(stopResult);
    }


}