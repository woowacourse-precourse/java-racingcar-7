package racingcar.view;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {
    private final InputView inputView = new InputView();

    private void checkValidationThrowsException(String testInput, String expectedMessage) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> inputView.validateInput(testInput));
        assertEquals(expectedMessage, thrownException.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 입력 검증 테스트")
    public void firstInputValidationTest(){
        assertAll(
                () -> assertTrue(inputView.validateInput("abcd,abc")),
                () -> assertTrue(inputView.validateInput("ads,abc,dsd,123")),
                () -> assertTrue(inputView.validateInput("abcd,abc,2323")),
                () -> assertTrue(inputView.validateInput("ad,abc,12345")),
                () -> assertTrue(inputView.validateInput("ad,abc,김bc1"))
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 에러메시지 테스트")
    public void firstInputValidationExceptionTest() {
        String longTestCase = "abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc";
        assertAll(
                () -> checkValidationThrowsException(longTestCase, "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("abc,abc", "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("abc", "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("", "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("abc,", "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("abcdef", "생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다."),
                () -> checkValidationThrowsException("abc,abcdefg", "이름은 1글자 이상, 5글자 이하 입니다."),
                () -> checkValidationThrowsException("abc,a bc", "이름은 숫자, 알파벳, 한글 조합만 가능합니다."),
                () -> checkValidationThrowsException("1###,1@,1\n234", "이름은 숫자, 알파벳, 한글 조합만 가능합니다.")
        );
    }

//    @Test
//    public void SecondInputExceptionTest() {
//        assertAll("두번째 입력 검증",
//                () -> checkValidationThrowsException(0, "시도할 횟수는 1이상 99999이하입니다."),
//                () -> checkValidationThrowsException(99999999, "시도할 횟수는 1이상 99999이하입니다.")
//        );
//    }





}


