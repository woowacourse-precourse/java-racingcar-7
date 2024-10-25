package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void Car_리스트로_변환_테스트() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        List<Car> cars = Converter.createCars(carNames);

        // then
        assertEquals(carNames.size(), cars.size(), "자동차 리스트 크기 불일치");
        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getName(), "자동차 이름 불일치");
            assertEquals(0, cars.get(i).getPosition(), "자동차 초기 위치 불일치");
        }
    }
}