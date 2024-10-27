package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ResultPrintTest {

    @Test
    void 결과_출력_테스트() {
        // Given
        Application.nameList = new String[]{"pobi", "woni"};
        Application.processResult = new String[]{"-", "--"};

        // When
        List<String> resultStrings = ResultPrint.getResultStrings();

        // Then
        assertThat(resultStrings).containsExactly("pobi : -", "woni : --");
    }
}