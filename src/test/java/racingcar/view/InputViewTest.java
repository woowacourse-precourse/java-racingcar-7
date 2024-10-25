package racingcar.view;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {
    private static final String CARNAME_ERROR_MESSAGE_COUNT = "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다.";
    private static final String CARNAME_ERROR_MESSAGE_LENGTH = "이름은 1글자 이상, 5글자 이하 입니다.";
    private static final String CARNAME_ERROR_MESSAGE_FORMAT = "이름은 숫자, 알파벳, 한글 조합만 가능합니다.";
    private static final String GAMECOUNT_ERROR_MESSAGE_LENGTH = "시도할 횟수는 1이상 99999이하의 숫자입니다.";
    private static final String GAMECOUNT_ERROR_MESSAGE_FORMAT = "숫자를 입력해주세요.";


    private final InputView inputView = new InputView();

    private static Stream<Arguments> provideCarNameCases() {
        return Stream.of(
                Arguments.of("abcd,abc"),
                Arguments.of("ads,abc,dsd,123"),
                Arguments.of("abcd,abc,2323"),
                Arguments.of("ad,abc,12345"),
                Arguments.of("ad,abc,김bc1")
        );
    }

    private static Stream<Arguments> provideCarNameExceptionCases() {
        return Stream.of(
                Arguments.of("abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("abc,abc", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("abc", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("abc,", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("abcdef", CARNAME_ERROR_MESSAGE_COUNT),
                Arguments.of("abc,abcdefg", CARNAME_ERROR_MESSAGE_LENGTH),
                Arguments.of("abc,a bc", CARNAME_ERROR_MESSAGE_FORMAT),
                Arguments.of("1###,1@,1\n234", CARNAME_ERROR_MESSAGE_FORMAT)
        );
    }

    private static Stream<Arguments> provideGameCountCases() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("2"),
                Arguments.of("9999")
        );
    }

    private static Stream<Arguments> provideGameCountExceptionCases() {
        return Stream.of(
                Arguments.of("abc", GAMECOUNT_ERROR_MESSAGE_FORMAT),
                Arguments.of("#DE,", GAMECOUNT_ERROR_MESSAGE_FORMAT),
                Arguments.of("-1", GAMECOUNT_ERROR_MESSAGE_LENGTH),
                Arguments.of("0", GAMECOUNT_ERROR_MESSAGE_LENGTH),
                Arguments.of("99999999", GAMECOUNT_ERROR_MESSAGE_LENGTH)
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

    @ParameterizedTest
    @MethodSource("provideGameCountCases")
    @DisplayName("시도할 횟수 입력 검증 테스트")
    public void validateGameCount(String test){
        assertTrue(inputView.validateGameCount(test));
    }

    @ParameterizedTest
    @MethodSource("provideGameCountExceptionCases")
    @DisplayName("시도할 횟수 입력 에러메시지 테스트")
    public void provideGameCountExceptionCases(String test, String expected) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> inputView.validateGameCount(test));
        assertEquals(expected, thrownException.getMessage());
    }

}


