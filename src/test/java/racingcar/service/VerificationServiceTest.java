package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.EmptyInputException;
import racingcar.exception.carName.InvalidCharacterException;
import racingcar.exception.carName.InvalidCarNameLengthException;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.carName.InvalidRegisterCarsInputLengthException;
import racingcar.exception.executionNumber.NotNumberException;
import racingcar.exception.executionNumber.NumberRangeException;

import static org.junit.jupiter.api.Assertions.*;
class VerificationServiceTest {

    private VerificationService verificationService;

    @BeforeEach
    void setUp() {
        verificationService = new VerificationService();
    }

    @Nested
    @DisplayName("자동차 등록 입력값 길이 테스트")
    class isValidRegisterCarsInputLengthTests {

        @Test
        void 빈_입력값_예외테스트() {
            String input = "";
            assertThrows(EmptyInputException.class, () -> verificationService.isValidRegisterCarsInputLength(input));
        }

        @Test
        void 최대_입력값_예외테스트() {
            String input = ".".repeat(1001);
            assertThrows(InvalidRegisterCarsInputLengthException.class, () -> verificationService.isValidRegisterCarsInputLength(input));
        }

        @Test
        void 최대_입력값_테스트() {
            String input = "a".repeat(1000);
            assertTrue(verificationService.isValidRegisterCarsInputLength(input));
        }
    }

    @Nested
    @DisplayName("단일 자동차 이름 입력값 길이 테스트")
    class IsValidLengthTests {

        @Test
        void 최소_길이_예외테스트() {
            List<String> carNames = new ArrayList<>();
            carNames.add("");
            assertThrows(EmptyInputException.class, () -> verificationService.isValidCarNameLength(carNames));
        }

        @Test
        void 최대_길이_예외테스트() {
            List<String> invalidCarNames = new ArrayList<>();
            invalidCarNames.add("abcdef");
            invalidCarNames.add("ghijklmnopqrstuvwxyz");
            assertThrows(InvalidCarNameLengthException.class, () -> verificationService.isValidCarNameLength(invalidCarNames));
        }

        @Test
        void 길이_테스트() {
            List<String> carNames = new ArrayList<>();
            carNames.add("a");
            carNames.add("bc");
            carNames.add("def");
            carNames.add("ghij");
            carNames.add("klmno");
            assertTrue(verificationService.isValidCarNameLength(carNames));
        }
    }

    @Nested
    @DisplayName("입력값 특수문자 여부 테스트")
    class ContainsInvalidCharacterTests {

        @Test
        void 숫자_포함_테스트() {
            String input = "1abc,def,ghijk";
            assertTrue(verificationService.containsInvalidCharacter(input));
        }

        @Test
        void 특수문자_포함_예외테스트() {
            String input = "^1abc,def,*ghijk";
            assertThrows(InvalidCharacterException.class, () -> verificationService.containsInvalidCharacter(input));
        }
    }


    @Nested
    @DisplayName("입력값에 숫자 여부 테스트")
    class IsNumberTests {

        @Test
        void 숫자_체크_테스트() {
            String input = "123";
            assertTrue(verificationService.isNumber(input));
        }

        @Test
        void 숫자외_예외테스트() {
            String input = "^abc";
            assertThrows(NotNumberException.class, () -> verificationService.isNumber(input));
        }
    }

    @Nested
    @DisplayName("시도 횟수 허용 범위 테스트")
    class IsValidExecutionRangeTests {

        @Test
        void 최소_범위_예외테스트() {
            String input = "0";
            assertThrows(NumberRangeException.class, () -> verificationService.isValidExecutionRange(input));
        }

        @Test
        void 최대_범위_예외테스트() {
            String input = "1001";
            assertThrows(NumberRangeException.class, () -> verificationService.isValidExecutionRange(input));
        }

        @Test
        void 최대_범위_테스트() {
            String input = "1000";
            assertTrue(verificationService.isValidExecutionRange(input));
        }
    }
}