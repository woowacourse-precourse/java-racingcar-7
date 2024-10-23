package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @Test
    public void 차_생성() {
        Map<String, Integer> cars = racingCar.createCar(new String[]{"pobi", "woni", "jun"});
        assertThat(cars).isEqualTo(new HashMap<String, Integer>() {{
            put("pobi", 0);
            put("woni", 0);
            put("jun", 0);
        }});
    }
}