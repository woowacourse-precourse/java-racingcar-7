package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    CarService carService = new CarService();

    @BeforeEach
    void beforeEach() {
        carService.addCar("a", 1);
        carService.addCar("b", 2);
        carService.addCar("c", 2);
    }

    @Test
    @DisplayName("자동차 추가 테스트 - 중복된 이름의 자동차가 있을 때 예외를 던진다.")
    void givenDuplicatedName_whenAddCar_thenIllegalArgumentException() {
        String duplicatedCarName = "a";
        int differentDistance = 2;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> carService.addCar(duplicatedCarName, differentDistance));
    }

    @Test
    @DisplayName("최대 거리 자동차 목록 가져오기 테스트")
    void givenBasicInput_whenGetCarsWithMaxDistance_thenCorrectResult() {
        List<String> expected = List.of("b", "c");
        List<String> result = carService.getCarsWithMaxDistance();
        assertThat(result).isEqualTo(expected);
    }

}