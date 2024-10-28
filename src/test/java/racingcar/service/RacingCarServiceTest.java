package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorStatus;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarServiceTest {

    Map<String, String> createCarsWithUniqueLengths() {
        Map<String, String> cars = new HashMap<>();
        cars.put("a", "--");
        cars.put("b", "----");
        cars.put("c", "-");
        return cars;
    }

    Map<String, String> createCarsWithTwoEqualLengths() {
        Map<String, String> cars = new HashMap<>();
        cars.put("a", "----");
        cars.put("b", "----");
        cars.put("c", "-");
        return cars;
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하일 경우 유효성 검사를 통과한다.")
    void validateCarNames() {
        RacingCarService racingCarService = new RacingCarService();
        Map<String, String> result = racingCarService.validateCarNames("a,b,c");
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 경우 예외처리한다.")
    void validateCarNamesException() {
        RacingCarService racingCarService = new RacingCarService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> racingCarService.validateCarNames("123456"));
        assertEquals(ErrorStatus.OVERSIZE_CAR_NAME, exception.getMessage());
    }

    @Test
    @DisplayName("우승자가 한명일 경우 우승자가 반환된다.")
    void findWinner() {
        RacingCarService racingCarService = new RacingCarService();
        Map<String, String> cars = createCarsWithUniqueLengths();

        String winner = racingCarService.findWinner(cars);

        assertEquals("b", winner);
    }

    @Test
    @DisplayName("우승자가 두 명일 경우 쉼표(,)를 이용하여 구분한다.")
    void findWinners() {
        RacingCarService racingCarService = new RacingCarService();
        Map<String, String> cars = createCarsWithTwoEqualLengths();

        String winner = racingCarService.findWinner(cars);

        assertEquals("a, b", winner);
    }
}