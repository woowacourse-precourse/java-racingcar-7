package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.constant.ErrorMessage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CarNameParser 테스트")
class CarNameParserTest {

    @Test
    @DisplayName("파서 테스트")
    void parse() {
        // given
        String input = "java,cpp,go";
        CarNameParser carNameParser = new CarNameParser(input);

        // when
        List<String> carNames = carNameParser.parse();

        // then
        assertEquals(3, carNames.size());
    }

    @Test
    @DisplayName("입력받은 문자열이 5글자를 초과하면 IllegalArgumentException 발생")
    void exceedCarNameLength() {
        // given
        String input = "python,java,cpp,go";
        CarNameParser carNameParser = new CarNameParser(input);

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, carNameParser::parse);

        // then
        assertEquals(ErrorMessage.EXCEED_CAR_NAME_LENGTH, exception.getMessage());
    }

    @Test
    @DisplayName("파서가 공백을 제거하는지 테스트")
    void inputShouldNotIncludeBlank() {
        // given
        String input = "ruby              ";
        CarNameParser carNameParser = new CarNameParser(input);

        // when
        List<String> carNames = carNameParser.parse();

        // then
        assertEquals(4, carNames.get(0).length());
    }
}
