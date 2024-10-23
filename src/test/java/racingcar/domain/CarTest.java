package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;
    private String carName;

    @BeforeEach
    void setUp() {
        carName = "kyj";
        car = new Car(carName);
    }

    @Test
    void 자동차_생성() {
        //given

        //when

        //then
        assertEquals("kyj : ", car.toString());
    }

    @Test
    void 자동차_전진() {
        //given

        //when
        car.move(() -> true);

        //then
        assertEquals("kyj : -", car.toString());
    }
}
