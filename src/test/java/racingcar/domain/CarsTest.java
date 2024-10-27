package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("입력 쉼표 기준으로 분리")
    @Test
    void splitInputByComma() {
        String carNames = "pobi,woni,jun";

        Cars cars = new Cars();
        cars.registerCars(carNames);
        List<Car> carList = cars.getCars();

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }

    @DisplayName("공백 있는 입력 쉼표 기준으로 분리")
    @Test
    void splitNamesWithSpaceByComma() {
        String carNames = "pobi, woni, jun";

        Cars cars = new Cars();
        cars.registerCars(carNames);
        List<Car> carList = cars.getCars();

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }
}
