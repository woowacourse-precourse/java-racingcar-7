package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputExtractorTest {

    @Test
    @DisplayName("문자열이 들어오면 쉼표를 구분자로 추출해 리스트로 반환한다.")
    void extractCarNamesList() {
        assertThat(InputExtractor.extractCarNames("bora,tubi,nana,po"))
                .containsExactly("bora", "tubi", "nana", "po");
    }

    @Test
    @DisplayName("문자열에 쉼표가 없으면 문자열을 그대로 반환하므로 리스트의 사이즈는 1이다.")
    void extractCarNamesListWithNoComma() {
        assertThat(InputExtractor.extractCarNames("boratubinanapo"))
                .hasSize(1);
    }

}
