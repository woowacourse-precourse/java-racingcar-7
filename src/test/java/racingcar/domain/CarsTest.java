package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("선수들 이름을 통해 Cars를 만들 수 있다")
    void testCreateCarsByNames() {
        Cars cars = Cars.createCarsByNames(List.of("a", "b", "c"));
        assertNotNull(cars);
    }
}
