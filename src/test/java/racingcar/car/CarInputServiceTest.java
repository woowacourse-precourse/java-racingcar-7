package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.IOUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarInputServiceTest {
    private CarInputService carInputService;

    @BeforeEach
    void setup() {
        CarInputValidator carInputValidator = new CarInputValidator();
        carInputService = new CarInputService(carInputValidator);
    }

    @Test
    @DisplayName("입력된 자동차 문자열을 콤마(,) 기준으로 분리하여 자동차 목록을 반환힌다.")
    void getCars() {
        String carInput = "car1, car2, car3";

        IOUtils.outputStringWithEnter("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> cars = carInputService.returnValidatedCars(carInput.split(","));

        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }
}
