package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.EmptyInputException;
import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidLengthException;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NotNumberException;

import static org.junit.jupiter.api.Assertions.*;
class VerificationServiceTest {

    private VerificationService verificationService;

    @BeforeEach
    void setUp() {
        verificationService = new VerificationService();
    }

    @Nested
    @DisplayName("자동차 이름 길이 테스트")
    class IsValidLengthTests {

        @Test
        void 최소_길이_예외테스트() {
            List<String> carNames = new ArrayList<>();
            carNames.add("");
            assertThrows(EmptyInputException.class, () -> verificationService.isValidLength(carNames));
        }

        @Test
        void 최대_길이_예외테스트() {
            List<String> invalidCarNames = new ArrayList<>();
            invalidCarNames.add("abcdef");
            invalidCarNames.add("ghijklmnopqrstuvwxyz");
            assertThrows(InvalidLengthException.class, () -> verificationService.isValidLength(invalidCarNames));
        }

        @Test
        void 길이_테스트() {
            List<String> carNames = new ArrayList<>();
            carNames.add("a");
            carNames.add("bc");
            carNames.add("def");
            carNames.add("ghij");
            carNames.add("klmno");
            assertTrue(verificationService.isValidLength(carNames));
        }
    }

    @Nested
    @DisplayName("입력값에 특수문자있는지 확인하는 테스트")
    class ContainsInvalidCharacterTests {

        // TODO : String 길이 최소치, 최대치를 정해서 테스트

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
    @DisplayName("숫자인지 확인하는 메소드 테스트")
    class IsNumberTests {

        // TODO : 숫자 최대치 최소치 테스트

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
}