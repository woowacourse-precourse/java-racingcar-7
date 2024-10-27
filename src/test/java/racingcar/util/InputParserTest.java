package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorStatus;

class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void parseCars_validInput() {
        String input = "car1,car2,car3";
        List<String> carNames = inputParser.parseCars(input);
        assertEquals(List.of("car1", "car2", "car3"), carNames);
    }

    @Test
    void parseCars_emptyInput() {
        String input = "";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseCars(input));
        assertEquals(ErrorStatus.EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    void parseCars_invalidCarName() {
        String input = "car1,car2,toolongname";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseCars(input));
        assertEquals(ErrorStatus.INVALID_CAR_NAME.getMessage(), exception.getMessage());
    }

    @Test
    void parseCars_maxLengthCarName() {
        String input = "car1,car2,car12";
        List<String> carNames = inputParser.parseCars(input);
        assertEquals(List.of("car1", "car2", "car12"), carNames);
    }

    @Test
    void parseCars_specialCharacters() {
        String input = "car1,car2,car@";
        List<String> carNames = inputParser.parseCars(input);
        assertEquals(List.of("car1", "car2", "car@"), carNames);
    }

    @Test
    void parseRound_validInput() {
        String input = "5";
        int round = inputParser.parseRound(input);
        assertEquals(5, round);
    }

    @Test
    void parseRound_emptyInput() {
        String input = "";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseRound(input));
        assertEquals(ErrorStatus.EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    void parseRound_invalidRound() {
        String input = "abc";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseRound(input));
        assertEquals(ErrorStatus.INVALID_ROUND_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    void parseRound_outOfBoundRound() {
        String input = "101";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseRound(input));
        assertEquals(ErrorStatus.ROUND_OUT_OF_BOUND.getMessage(), exception.getMessage());
    }

    @Test
    void parseRound_boundaryRound_min() {
        String input = "1";
        int round = inputParser.parseRound(input);
        assertEquals(1, round);
    }

    @Test
    void parseRound_boundaryRound_max() {
        String input = "100";
        int round = inputParser.parseRound(input);
        assertEquals(100, round);
    }

    @Test
    void parseRound_outOfBoundRound_belowMin() {
        String input = "0";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseRound(input));
        assertEquals(ErrorStatus.ROUND_OUT_OF_BOUND.getMessage(), exception.getMessage());
    }

}
