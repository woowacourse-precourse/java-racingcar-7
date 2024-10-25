package racingcar.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("CarNameParser 기능 테스트")
class CarNameParserTest {

    private final CarNameParser carNameParser = new CarNameParser();

    @DisplayName("쉼표(,)를 이용해서 자동차 이름을 구분하고 공백을 제거해서 리스트로 이름들을 반환한다.")
    @Test
    void success1() {
        String input = "pobi,  woni  , jun";
        List<String> carNames = carNameParser.parseAndTrimCarNames(input);
        assertEquals(List.of("pobi", "woni", "jun"), carNames);
    }

}