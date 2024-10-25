package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.CarValidator;
import racingcar.validator.RoundValidator;

public class InputTest {
    private static final String CAR_NAMES = "emily, tomas, gina";
    private static final String LAST_CAR_NAME = "gina";
    private static final int NUMBER_OF_ROUNDS = 5;

    @Test
    void 자동차이름_입력_테스트() {
        Cars cars = new Cars();
        cars.addCarFromString(CAR_NAMES);

        assertEquals(3, cars.getCarList().size());

        Car lastCar = cars.getCarList().getLast();
        assertNotNull(lastCar);
        assertEquals(LAST_CAR_NAME, lastCar.getName());

    }

    @Test
    void 자동차이름_유효성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarValidator.isValid(",,,");
        });
    }

    @Test
    void 라운드횟수_유효성_테스트(){
        assertThrows(IllegalArgumentException.class, () -> {
            RoundValidator.isValid("");
            RoundValidator.isValid("ff");
            RoundValidator.isValid("-1");
        });
    }

}
