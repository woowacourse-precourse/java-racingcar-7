package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarGeneratorTest {

    @Test
    void 자동차_생성_테스트() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarGenerator carGenerator = new CarGenerator();
        List<Car> cars = carGenerator.generateCars(carNames);

        assertThat(cars)
                .allMatch(car -> carNames.contains(car.getName()));
    }

}