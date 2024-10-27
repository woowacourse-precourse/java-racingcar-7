package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExtractorTest {

    @Test
    @DisplayName("문자열이 들어오면 쉼표를 구분자로 추출해 리스트로 반환한다.")
    void extractCarNamesListTest() {
        assertThat(InputExtractor.extractCarNames("bora,tubi,nana,po"))
                .containsExactly("bora", "tubi", "nana", "po");
    }

    @Test
    @DisplayName("문자열에 쉼표가 없으면 문자열을 그대로 반환하므로 리스트의 사이즈는 1이다.")
    void extractCarNamesListWithNoCommaTest() {
        assertThat(InputExtractor.extractCarNames("boratubinanapo"))
                .hasSize(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"welcome", "java!", "3.14", "-1", "0", "@@", "\n"})
    @DisplayName("총 시행횟수에 양의 정수가 아닌 것을 입력하면 IllegalArgumentException이 발생한다.")
    void extractRoundTest(String userInputRound) {
        assertThatThrownBy(() -> InputExtractor.extractRound(userInputRound))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
