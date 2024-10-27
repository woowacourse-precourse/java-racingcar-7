package racingcar.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.exception.CarNameException;
import racingcar.exception.TryNumberException;

public class InputParserTest {

    @Test
    @DisplayName("parserCarName 테스트")
    void parserCarNameTest() {
        // given
        String carNames = "ruby,paul,jun";

        // when
        CarNameRequest carNameRequest = InputParser.parseCarName(carNames);

        // then
        assertEquals("ruby", carNameRequest.carNameList().get(0));
        assertEquals("paul", carNameRequest.carNameList().get(1));
        assertEquals("jun", carNameRequest.carNameList().get(2));
    }

    @Test
    @DisplayName("carNames가 빈 문자열인 경우 테스트")
    void carNamesEmptyTest() {
        // given
        String carNames = "";

        // when-then
        assertThrows(CarNameException.class, () -> InputParser.parseCarName(carNames));
    }

    @Test
    @DisplayName("carNames가 공백인 경우 테스트")
    void carNamesBlankTest() {
        // given
        String carNames = " ";

        // when-then
        assertThrows(CarNameException.class, () -> InputParser.parseCarName(carNames));
    }

    @Test
    @DisplayName("carNames ',' 사이에 공백이 있는 경우")
    void carNamesContainEmptyTest() {
        // given
        String carNames = "pobi,,ruby";

        // when-then
        assertThrows(CarNameException.class, () -> InputParser.parseCarName(carNames));
    }

    @Test
    @DisplayName("carNames ','로 시작하는 경우")
    void carNamesStartCommaTest() {
        // given
        String carNames = ",pobi,ruby";

        // when-then
        assertThrows(CarNameException.class, () -> InputParser.parseCarName(carNames));
    }

    @Test
    @DisplayName("carNames가 5글자 초과 테스트")
    void carNamesOverSizeTest() {
        // given
        String carNames = "Robbie,Bobby,Ruby";

        // when-then
        assertThrows(CarNameException.class, () -> InputParser.parseCarName(carNames));
    }

    @Test
    @DisplayName("tryNumber 테스트")
    void parseTryNumberTest() {
        // given
        String tryNumber = "5";

        // when
        TryNumberRequest tryNumberRequest = InputParser.parseTryNumber(tryNumber);

        // then
        assertEquals(Integer.parseInt(tryNumber), tryNumberRequest.tryNumber());
    }

    @Test
    @DisplayName("tryNumber empty 테스트")
    void tryNumberEmptyTest() {
        // given
        String tryNumber = "";

        // when - then
        assertThrows(TryNumberException.class, () -> InputParser.parseTryNumber(tryNumber));
    }

    @Test
    @DisplayName("tryNumber blank 테스트")
    void tryNumberBlankTest() {
        // given
        String tryNumber = " ";

        // when - then
        assertThrows(TryNumberException.class, () -> InputParser.parseTryNumber(tryNumber));
    }

    @Test
    @DisplayName("tryNumber Not Int 테스트")
    void tryNumberNotIntTest() {
        // given
        String tryNumber = "t";

        // when - then
        assertThrows(TryNumberException.class, () -> InputParser.parseTryNumber(tryNumber));
    }

}
