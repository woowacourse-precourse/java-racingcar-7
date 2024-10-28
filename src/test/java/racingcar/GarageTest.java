package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GarageTest {

    @Test
    void 자동차_개수_2개_미만인지_검사() {
        List<String> carName = List.of("소정");

        Assertions.assertThatThrownBy(() -> {
                    new Garage(carName);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 적어도 2개 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름_중복_검사() {
        List<String> carNameList = List.of("소정", "소정");

        Assertions.assertThatThrownBy(() -> {
                    new Garage(carNameList);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

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
