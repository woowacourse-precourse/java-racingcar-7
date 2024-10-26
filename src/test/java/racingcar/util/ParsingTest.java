package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.Parsing.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("파싱 테스트")
class ParsingTest {
    @Test
    @DisplayName("구분자로 분리된 문자열을 배열로 변환")
    void testSplitCarName() {
        assertThat(splitCarName("test1,test2,test3")).isEqualTo(new String[]{"test1", "test2", "test3"});
    }

    @Test
    @DisplayName("문자열 배열을 플레이어 맵으로 변환")
    void testConvertStringArrToMap() {
        Map<String, String> expectedPlayer = new LinkedHashMap<>();
        expectedPlayer.put("test1", "");
        expectedPlayer.put("test2", "");
        expectedPlayer.put("test3", "");
        assertThat(convertStringArrToMap(new String[]{"test1", "test2", "test3"})).isEqualTo(expectedPlayer);
    }

    @Test
    @DisplayName("우승자 리스트를 구분자로 연결된 문자열로 변환")
    void testJoinWinner() {
        List<String> winner = List.of("test1", "test2");
        String expectedWinner = "test1, test2";
        assertThat(joinWinner(winner)).isEqualTo(expectedWinner);
    }
}