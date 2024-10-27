package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarServiceTest {
    @Test
    void 자동차입력_테스트() {
        CarService carService = new CarService();
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(null));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(",,,"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter("pobi,,coh"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(""));
    }
}