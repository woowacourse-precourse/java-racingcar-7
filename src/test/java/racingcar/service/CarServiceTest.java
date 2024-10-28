package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    void 자동차_이름_예외_테스트() {
        // 자동차 이름이 5자 초과일 때 예외 발생 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            carService.validateCarNames("pobiiiii");
        });

        // 중복된 자동차 이름이 있을 때 예외 발생 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            carService.validateCarNames("pobi,pobi");
        });
    }

}
