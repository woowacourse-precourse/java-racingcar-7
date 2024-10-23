package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    CarService carService = new CarService();

    @BeforeEach
    void beforeEach(){
        carService.addCar("a");
        carService.addCar("b");
    }

    @Test
    @DisplayName("자동차 추가 테스트 - 중복된 이름의 자동차가 있을 때 예외를 던진다.")
    void givenDuplicatedName_whenAddCar_thenIllegalArgumentException(){
        String duplicatedCarName = "a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> carService.addCar(duplicatedCarName));
    }

}