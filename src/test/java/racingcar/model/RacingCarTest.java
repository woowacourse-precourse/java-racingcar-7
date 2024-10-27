package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void TO_STRING_출력_테스트() {
        RacingCar car = new RacingCar("kim");
        assertEquals("kim : ", car.toString());
    }
}
