package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarNames.createCarNames;

class CarNamesTest {
    @Test
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni");

        assertThat(createCarNames(carName)).isEqualTo(expectedCarNames);
    }
}