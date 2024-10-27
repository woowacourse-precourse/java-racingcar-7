package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExtractorTest {

    @Test
    @DisplayName("자동차이름 문자열이 들어오면 쉼표를 구분자로 추출해 리스트로 반환한다.")
    void testExtractCarNamesList() {
        assertThat(InputExtractor.extractCarNames("bora,tubi,nana,po"))
                .containsExactly("bora", "tubi", "nana", "po");
    }

    @Test
    @DisplayName("자동차 이름 조건은 5자 이하이므로, 5자 이상을 입력하면 IllegalArgumentException이 발생한다.")
    void testExtractCarNamesListWithNoComma() {
        assertThatThrownBy(() -> InputExtractor.extractCarNames("boradori"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","      "})
    @NullSource
    @DisplayName("입력된 자동차이름이 비어있거나 null이면 IllegalArgumentException이 발생한다.")
    void testExtractCarNamesListNull(String userInputCar) {
        assertThatThrownBy(() -> InputExtractor.extractCarNames(userInputCar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    @NullSource
    @DisplayName("입력된 총시행횟수가 비어있거나 null이면 IllegalArgumentException이 발생한다.")
    void testExtractRoundNull(String userInputRound) {
        assertThatThrownBy(() -> InputExtractor.extractRound(userInputRound))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"welcome", "java!", "3.14", "-1", "0", "@@", "\n"})
    @NullSource
    @DisplayName("총 시행횟수에 양의 정수가 아닌 것을 입력하면 IllegalArgumentException이 발생한다.")
    void testExtractRound(String userInputRound) {
        assertThatThrownBy(() -> InputExtractor.extractRound(userInputRound))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
