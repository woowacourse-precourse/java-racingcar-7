package racingcar.front.parser;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.front.exception.InvalidCarNameInputException;

class CommaDelimiterParserTest {

    @Test
    @DisplayName("컴마로 분리된 문자열 파싱 테스트")
    void 문자열_파싱_테스트() {
        //given
        String delimitedName = "kim,lee,choi";
        List<String> expectedNames = List.of("kim", "lee", "choi");

        //when
        List<String> parsedStrings = CommaDelimiterParser.parse(delimitedName);

        //then
        assertThat(parsedStrings).containsAll(expectedNames);

    }

    @Test
    @DisplayName("컴마로 분리된 문자열 길이가 5를 넘어갔을 때 예외 처리")
    void 문자열_파싱_예외_테스트1() {
        //given
        String delimitedName = "kimminjung,lee,choi";
        //when
        //then
        assertThatThrownBy(() -> CommaDelimiterParser.parse(delimitedName)).isInstanceOf(
                InvalidCarNameInputException.class);
    }

    @Test
    @DisplayName("컴마로 분리된 문자열의 형식이 정규 표현식에 맞지 않을 때 예외 처리")
    void 문자열_파싱_예외_테스트3() {
        //given
        String delimitedName = "kasg,,lee,choi";
        //when
        //then
        assertThatThrownBy(() -> CommaDelimiterParser.parse(delimitedName)).isInstanceOf(
                InvalidCarNameInputException.class);
    }
}