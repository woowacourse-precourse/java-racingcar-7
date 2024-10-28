package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.util.Validator;

class CarSetupServiceTest {

    private final CarSetupService carSetupService = new CarSetupService();

    @Test
    void 자동차_리스트_생성_테스트() {
        String carNamesInput = "pobi,woni";
        List<Car> cars = carSetupService.setupCars(carNamesInput);

        assertEquals(2, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
    }

    @Test
    void 자동차_이름_검증_테스트() {
        List<String> carNames = List.of("pobi", "javaji"); // 5글자 초과
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNameLength(carNames));
    }
}
