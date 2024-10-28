package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.extractor.car.name.CarNameExtractorImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtractorTest {

    private CarNameExtractorImpl carNameExtractor;

    @BeforeEach
    public void setUp() {
        carNameExtractor = new CarNameExtractorImpl();
    }

    @DisplayName("쉼표로 구분된 자동차 이름 문자열이 배열로 잘 반환되는지 Test")
    @Test
    public void extractFromInputString_ShouldReturnListOfCarNames_WhenInputIsValid() {
        String input = "Car1,Car2,Car3";

        String[] carNames = carNameExtractor.extractFromInputString(input);

        assertThat(carNames).containsExactly("Car1", "Car2", "Car3");
    }
}
