package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarNames.createCarNames;

class CarNamesTest {
    @Test
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni");

        assertThat(createCarNames(carName)).isEqualTo(expectedCarNames);
    }

    @Test
    void 자동차_이름_부여_테스트() {
        List<String> carNames = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(carNames);
        Map<String, Boolean> carNamesMatchResult = cars.isCarsName(carNames);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("pobi", true);
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("woni", true);
        });
    }
}