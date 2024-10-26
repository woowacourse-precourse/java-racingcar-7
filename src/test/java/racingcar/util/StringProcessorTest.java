package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringProcessorTest {

    private final StringProcessor stringProcessor = new StringProcessor();

    @Test
    @DisplayName("여러 가지 이름을 가지고 있는 것 같다면 true 반환")
    void t001() {

        //given
        String testInput = "pobi,seo";

        //when
        boolean result = stringProcessor.hasMultipleCarNames(testInput);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("여러 이름을 가지고 있지 않는 것 같다면 false 반환")
    void t002() {
        //given
        String testInput = "seo";

        //when
        boolean result = stringProcessor.hasMultipleCarNames(testInput);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("여러 입력에 대해 특정 구분자로 분리처리를 할 수 있음")
    void t003() {
        //givne
        String testInput = "pobi,seo";

        //when
        List<String> carNames = stringProcessor.splitCarNames(testInput);

        //then
        assertThat(carNames).containsExactly("pobi", "seo");
    }
}