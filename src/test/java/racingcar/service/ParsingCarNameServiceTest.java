package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class ParsingCarNameServiceTest {
    @Test
    void 자동차_이름_추출_테스트() {
        String inputCarName = "pobi, crong,    juni,,,, kime, , ,  min";
        List<Car> expectedCars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("juni"), new Car("kime"), new Car("min"));

        List<Car> actualCars = ParsingCarNameService.parseCarNames(inputCarName);

        assertEquals(expectedCars.size(), actualCars.size());
        for (int i = 0; i < expectedCars.size(); i++) {
            assertEquals(expectedCars.get(i).getCarName(), actualCars.get(i).getCarName());
        }
    }
}
