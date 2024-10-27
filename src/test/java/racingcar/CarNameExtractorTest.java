package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameExtractorTest {

    @Test
    void 이름문자열에서_이름_추출해서_배열_반환() {
        // give
        String carNames = "소정,pobi,woni,jun";
        CarNameExtractor carNameExtractor = new CarNameExtractor(carNames);

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

    @Test
    void 이름문자열이_Null인지_검사() {
        String carNames = null;

        Assertions.assertThatThrownBy(() -> {
                    new CarNameExtractor(carNames);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 입력할 수 없습니다.");
    }

    @Test
    void 이름문자열이_빈문자열인지_검사() {
        String carNames = "";

        Assertions.assertThatThrownBy(() -> {
                    new CarNameExtractor(carNames);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열과 공백은 입력할 수 없습니다.");
    }

    @Test
    void 이름문자열이_공백인지_검사() {
        String carNames = " ";

        Assertions.assertThatThrownBy(() -> {
                    new CarNameExtractor(carNames);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열과 공백은 입력할 수 없습니다.");
    }
}
