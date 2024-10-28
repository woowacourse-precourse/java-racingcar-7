package racingcar.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameExtractorTest {

    private final CarNameExtractor carNameExtractor = new CarNameExtractor();

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 유효한_입력_문자열(String input) {
        String[] carNames = carNameExtractor.extractCarName(input);
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1, ,car3"})
    void 공백_포함_문자열(String input) {
        String[] carNames = carNameExtractor.extractCarName(input);
        assertThat(carNames).containsExactly("car1", " ", "car3");
    }


}