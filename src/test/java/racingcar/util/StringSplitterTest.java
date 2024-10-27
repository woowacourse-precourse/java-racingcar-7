package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    @Test
    @DisplayName("쉼표를 기준으로 구분할 수 있다")
    void 쉼표기준구분() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        List<String> carNameList = StringSplitter.splitByComma(carNames);

        // then
        List<String> expectedCarNames = List.of("pobi", "woni", "jun");

        // 두 리스트가 동일한지 비교
        assertEquals(expectedCarNames, carNameList);
        assertIterableEquals(expectedCarNames, carNameList);
    }
}