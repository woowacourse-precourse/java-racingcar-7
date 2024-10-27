package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.validator.InputValidator;

import java.util.List;

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

    @Test
    @DisplayName("입력값이 Car 객체 리스트로 변환되는지 검증 테스트")
    void testParseCarNames() {
        String input = "YOON,WOONG,CHAN";

        List<Car> cars = carSetupService.parseCarNames(input);

        assertEquals(3, cars.size());

        assertEquals("YOON", cars.get(0).getName());
        assertEquals(0, cars.get(0).getPosition());

        assertEquals("WOONG", cars.get(1).getName());
        assertEquals(0, cars.get(1).getPosition());

        assertEquals("CHAN", cars.get(2).getName());
        assertEquals(0, cars.get(2).getPosition());
    }
}
