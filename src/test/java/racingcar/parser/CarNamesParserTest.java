package racingcar.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesParserTest {

    @Test
    @DisplayName("유효한 입력이 주어졌을 때 이름 리스트로 변환한다.")
    public void parseCarNamesWithValidInput() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> result = CarNamesParser.parseCarNames(input);

        // then
        assertEquals(List.of("pobi", "woni", "jun"), result);
    }

    @Test
    @DisplayName("하나의 이름만 입력되었을 때 이름 리스트로 변환한다.")
    public void parseCarNamesWithSingleName() {
        // given
        String input = "pobi";

        // when
        List<String> result = CarNamesParser.parseCarNames(input);

        // then
        assertEquals(List.of("pobi"), result);
    }

    @Test
    @DisplayName("이름 앞뒤에 쉼표가 포함된 경우에 정상적으로 이름 리스트로 변환한다.")
    public void parseCarNamesWithLeadingAndTrailingCommas() {
        // given
        String input = ",pobi,woni,";

        // when
        List<String> result = CarNamesParser.parseCarNames(input);

        // then
        assertEquals(List.of("pobi", "woni"), result);
    }

    @Test
    @DisplayName("이름 사이에 공백이 포함된 경우 공백을 제거하여 이름 리스트로 변환한다.")
    public void parseCarNamesWithExtraSpaces() {
        // given
        String input = " pobi , woni , jun ";

        // when
        List<String> result = CarNamesParser.parseCarNames(input);

        // then
        assertEquals(List.of("pobi", "woni", "jun"), result);
    }

    @Test
    @DisplayName("중복된 이름이 존재할 경우에 예외를 발생시킨다.")
    public void parseCarNamesWithDuplicateNamesThrowsException() {
        // given
        String input = "pobi,woni,pobi";

        // when & then
        assertThrows(RacingException.class, () ->
                CarNamesParser.parseCarNames(input)
        );
    }
}