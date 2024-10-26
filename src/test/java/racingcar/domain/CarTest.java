package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 유효한_이름으로_Car_객체_생성() {
        String validName = "pobi";
        Car car = new Car(validName);
        assertNotNull(car);
    }

    @Test
    void 유효한_이름으로_예외없이_Car_객체_생성() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

    @Test
    void 유효하지_않은_이름으로_예외없이_Car_객체_생성() {
        String validName = "pobijk";
        assertThrows(IllegalArgumentException.class, () -> new Car(validName));
    }

//    @Test
//    void 전진조건_만족시_위치가_증가한다() {
//        Car car = new Car("pobi");
//        car.move(4);
//        assertEquals(1, car.getPosition());
//    }
//
//    @Test
//    void 전진조건_불만족시_위치가_변하지_않는다() {
//        Car car = new Car("pobi");
//        car.move(3);
//        assertEquals(0, car.getPosition());
//    }

}

