package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameExtractorTest {

    @Test
    void 이름문자열에서_이름_추출해서_배열_반환() {
        // give
        CarNameExtractor carNameExtractor = new CarNameExtractor();
        String carNames = "소정,pobi,woni,jun";

        List<String> expectedCarNameList = new ArrayList<>();
        expectedCarNameList.add("소정");
        expectedCarNameList.add("pobi");
        expectedCarNameList.add("woni");
        expectedCarNameList.add("jun");

        // when
        List<String> actualCarNameList = carNameExtractor.extractCarNames(carNames);

        // then
        Assertions.assertThat(actualCarNameList).isEqualTo(expectedCarNameList);
    }
}
