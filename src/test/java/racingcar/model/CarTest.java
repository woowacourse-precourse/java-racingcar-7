package racingcar.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;
    private String name = "pobi";

    @BeforeEach
    void setUpCar() {
        car = new Car(name);
    }

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
        assertEquals(name, carName);
    }

    @DisplayName("Car_이동_테스트")
    @Test
    public void moveOrStopTest() {
        //given
        //when
        boolean moveResult = car.moveOrStop(4);
        boolean stopResult = car.moveOrStop(3);
        //then
        assertTrue(moveResult);
        assertFalse(stopResult);
    }


}