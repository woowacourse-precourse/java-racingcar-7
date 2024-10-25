package racingcar.view;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {
    private static final String ERROR_MESSAGE_COUNT = "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다.";
    private static final String ERROR_MESSAGE_NAME_LENGTH = "이름은 1글자 이상, 5글자 이하 입니다.";
    private static final String ERROR_MESSAGE_NAME_FORMAT = "이름은 숫자, 알파벳, 한글 조합만 가능합니다.";

    private final InputView inputView = new InputView();

    private static Stream<Arguments> provideCarNameCases(){
        return Stream.of(
                Arguments.of("abcd,abc"),
                Arguments.of("ads,abc,dsd,123"),
                Arguments.of("abcd,abc,2323"),
                Arguments.of("ad,abc,12345"),
                Arguments.of("ad,abc,김bc1")
        );
    }

    private static Stream<Arguments> provideCarNameExceptionCases(){
        return Stream.of(
                Arguments.of("abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc", ERROR_MESSAGE_COUNT),
                Arguments.of("abc,abc", ERROR_MESSAGE_COUNT),
                Arguments.of("abc", ERROR_MESSAGE_COUNT),
                Arguments.of("", ERROR_MESSAGE_COUNT),
                Arguments.of("abc,", ERROR_MESSAGE_COUNT),
                Arguments.of("abcdef", ERROR_MESSAGE_COUNT),
                Arguments.of("abc,abcdefg", ERROR_MESSAGE_NAME_LENGTH),
                Arguments.of("abc,a bc", ERROR_MESSAGE_NAME_FORMAT),
                Arguments.of("1###,1@,1\n234", ERROR_MESSAGE_NAME_FORMAT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCarNameCases")
    @DisplayName("자동차 이름 입력 검증 테스트")
    public void validateCarNameTest(String test) {
        assertTrue(inputView.validateCarName(test));
    }

    @ParameterizedTest
    @MethodSource("provideCarNameExceptionCases")
    @DisplayName("자동차 이름 입력 에러메시지 테스트")
    public void validateCarNameExceptionTest(String test, String expected) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> inputView.validateCarName(test));
        assertEquals(expected, thrownException.getMessage());
    }

//    @Test
//    @DisplayName("시도할 횟수 입력 에러메시지 테스트")
//    public void SecondInputExceptionTest() {
//        assertAll(
//                () -> checkValidationThrowsException(0, "시도할 횟수는 1이상 99999이하입니다."),
//                () -> checkValidationThrowsException(99999999, "시도할 횟수는 1이상 99999이하입니다."),
//                () -> checkValidationThrowsException("1")
//        );
//    }




}


