package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CarServiceTest {
    private final CarService carService = new CarService();
    @Test
    void 자동차입력_테스트() {
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(null));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(",,,"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter("pobi,,coh"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(""));
    }

    @Test
    void 숫자변환_테스트() {
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(null));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(" "));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(""));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("5.3"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("-1"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("2147483648"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("-2147483649"));

        Assertions.assertThat(carService.getNumber("5")).isEqualTo(5);
        Assertions.assertThat(carService.getNumber("2147483647")).isEqualTo(2147483647);
    }
}