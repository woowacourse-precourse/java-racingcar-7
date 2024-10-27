package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageTest {

    @Test
    void 자동차_이름_배열로_자동차_배열_생성() {
        // give
        List<String> carNameList = List.of("소정", "pobi", "woni", "jun");
        Map<String, Integer> expectedCarMap = new LinkedHashMap<>();
        expectedCarMap.put("소정", 0);
        expectedCarMap.put("pobi", 0);
        expectedCarMap.put("woni", 0);
        expectedCarMap.put("jun", 0);

        // when
        Garage garage = new Garage(carNameList);

        // then
        Assertions.assertThat(garage.tellAllCarDecision()).isEqualTo(expectedCarMap);
    }
}
