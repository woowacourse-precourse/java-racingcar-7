package racingcar.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.validator.InputValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    private InputParser inputParser;
    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
        inputParser = new InputParser(inputValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,YOON,CHAN"})
    @DisplayName("자동차 이름이 중복될 때 예외 발생")
    public void testDuplicateCarName(String input) {
        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputParser.parseCarNames(input));
        // Then
        assertEquals("중복된 자동차 이름이 있습니다", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,WOONG,CHAN"})
    @DisplayName("자동차 이름이 중복되지 않으면 정상 통과")
    public void testUniqueCarName(String input) {
        // When & then
        assertDoesNotThrow(() -> inputParser.parseCarNames(input));
    }

    @Test
    @DisplayName("입력값이 Car 객체 리스트로 변환되는지 검증 테스트")
    void testParseCarNames() {
        // given
        String input = "YOON,WOONG,CHAN";

        // when
        List<Car> cars = inputParser.parseCarNames(input);

        // then
        assertEquals(3, cars.size());

        assertEquals("YOON", cars.get(0).getName());
        assertEquals(0, cars.get(0).getPosition());

        assertEquals("WOONG", cars.get(1).getName());
        assertEquals(0, cars.get(1).getPosition());

        assertEquals("CHAN", cars.get(2).getName());
        assertEquals(0, cars.get(2).getPosition());
    }
}
