package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ResultPrintTest {

    @Test
    void 결과_출력_테스트() {
        // Given
        Application.nameList = new ArrayList<>(Arrays.asList("pobi", "woni"));
        Application.processResult = new String[]{"-", "--"};

        // When
        List<String> resultStrings = ResultPrint.getResultStrings();

        // Then
        assertThat(resultStrings).containsExactly("pobi : -", "woni : --");
    }
}