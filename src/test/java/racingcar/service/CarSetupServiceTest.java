package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.validator.InputValidator;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CarSetupServiceTest {

    private CarSetupService carSetupService;
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
        carSetupService = new CarSetupService(inputValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,YOON,CHAN"})
    @DisplayName("자동차 이름이 중복될 때 예외 발생")
    void testDuplicateCarName(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> carSetupService.parseCarNames(input));

        assertEquals("중복된 자동차 이름이 있습니다", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"YOON,WOONG,CHAN"})
    @DisplayName("자동차 이름이 중복되지 않으면 정상 통과")
    void testUniqueCarName(String input) {
        assertDoesNotThrow(() -> carSetupService.parseCarNames(input));
    }

    @ParameterizedTest
    @MethodSource("carNamesProvider")
    @DisplayName("입력값이 Car 객체 리스트로 변환되는지 검증 테스트")
    void testParseCarNames(String[] carNames, int expectedSize) {
        List<Car> cars = carSetupService.parseCarNames(String.join(",", carNames));

        assertEquals(expectedSize, cars.size());

        for (int i = 0; i < expectedSize; i++) {
            assertEquals(carNames[i], cars.get(i).getName());
            assertEquals(0, cars.get(i).getPosition());
        }
    }

    static Stream<Arguments> carNamesProvider() {
        return Stream.of(
                Arguments.arguments(new String[]{"YOON", "WOONG", "CHAN"}, 3),
                Arguments.arguments(new String[]{"CAR1", "CAR2"}, 2),
                Arguments.arguments(new String[]{"CAR1"}, 1)
        );
    }
}
