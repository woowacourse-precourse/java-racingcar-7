package racingcar.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자가 입력한 자동차 이름 목록에 대해 리스트 파싱 검사")
class CarNameParserTest {

    @Test
    public void 자동차_이름_앞뒤에_공백_있을시_제거() {
        // given
        String rawCarNames = "    one,  two    ,three   ";

        // when
        List<String> parsedCarName = CarNameParser.parseCarName(rawCarNames);

        // then
        Assertions.assertThat(parsedCarName)
                .hasSize(3)
                .containsExactly("one", "two", "three");
    }

    @Test
    public void 사용자_입력에_콤마와_공백만_존재시_빈문자열_리스트_반환() {
        // given
        String rawCarNames = "    ,  ,,,    ,   ";

        // when
        List<String> parsedCarName = CarNameParser.parseCarName(rawCarNames);

        // then
        Assertions.assertThat(parsedCarName)
                .hasSize(6)
                .containsExactly("", "", "", "", "", "");
    }
}