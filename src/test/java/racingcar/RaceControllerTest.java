package racingcar;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    @Test
    void 우승자_테스트() {
        LinkedHashMap<Car, Integer> cars = new LinkedHashMap<>();
        cars.put(new Car("tayo"), 3);
        cars.put(new Car("lani"), 3);
        cars.put(new Car("rogi"), 2);
        List<String> expectedResults = List.of("tayo", "lani");

        var runner = new RaceController(cars, 5);
        List<String> actualResults = runner.findWinner();

        assertThat(actualResults).isEqualTo(expectedResults);
    }
}
