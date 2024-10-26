package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.service.Accelerator;
import racingcar.service.RandomNumberAccelerator;
import racingcar.util.MockNumberGenerator;
import racingcar.util.NumberGenerator;

class RaceTest {
    @DisplayName("자동차 이름 중복시 생성 불가능")
    @Test
    void duplicateCars() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race.of("car,car,car2");
        });
    }

    @DisplayName("입력이 비어있을경우 생성 불가능")
    @Test
    void blankCars() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race.of("");
        });
    }

    @DisplayName("자동차 경주시 현재 위치 확인")
    @Test
    void SuccessCars() {
        Race cars = Race.of("car1,car2,car3");
        NumberGenerator numberGenerator = new MockNumberGenerator(3, 4, 5, 1, 6, 3);
        // 멈춤, 전진, 전진 | 멈춤, 전진, 멈춤
        Accelerator accelerator = new RandomNumberAccelerator(numberGenerator);
        for (int i = 0; i < 2; i++) {
            cars.play(accelerator);
        }
        CarDto currentCars = cars.getCurrentDistances();
        Map<String, Integer> carDto = currentCars.carDto();
        Map<String, Integer> expected = Map.of("car1", 0, "car2", 2, "car3", 1);
        assertEquals(expected, carDto);
    }

    @DisplayName("자동차 경주시 중복 우승자 선별 확인")
    @Test
    void getWinners() {
        Race cars = Race.of("car1,car2,car3");
        NumberGenerator numberGenerator = new MockNumberGenerator(3, 4, 5, 1, 6, 9);
        // 멈춤, 전진, 전진 | 전진, 전진, 전진 -> 우승자 car2 car3
        Accelerator accelerator = new RandomNumberAccelerator(numberGenerator);
        for (int i = 0; i < 2; i++) {
            cars.play(accelerator);
        }
        CarDto winnersCarDto = cars.getWinners();
        Map<String, Integer> winners = winnersCarDto.carDto();
        Map<String, Integer> expected = Map.of("car2", 2, "car3", 2);
        assertEquals(expected, winners);
    }

}