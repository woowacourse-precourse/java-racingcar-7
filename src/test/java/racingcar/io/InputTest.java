package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    private final InputStream standardIn = System.in;
    private Input input;

    @BeforeEach
    void setUp() {
        input = Input.getInstance();
        System.setIn(standardIn);
    }

    @AfterAll
    static void cleanUp() {
        Console.close();
    }

    private void setInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Console.close();
    }

    @Test
    @DisplayName("연속된 콤마가 있을 경우 오류를 반환하는지 확인")
    void throwErrorsWhenConsecutiveCommas() {
        setInput("pobi,,woni\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.carNames();
        }, "Write valid comma between names");
    }

    @Test
    @DisplayName("콤마로 시작할 경우 오류를 반환하는지 확인")
    void throwErrorsWhenStartsWithComma() {
        setInput(",pobi,woni\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.carNames();
        }, "Write valid comma between names");
    }

    @Test
    @DisplayName("콤마로 끝날 경우 오류를 반환하는지 확인")
    void throwErrorsWhenEndsWithComma() {
        setInput("pobi,woni,\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.carNames();
        }, "Write valid comma between names");
    }

    @Test
    @DisplayName("정상적인 콤마 구분된 입력은 오류를 반환하지 않음")
    void acceptValidCommaInput() {
        setInput("pobi,woni,jun\n");
        assertDoesNotThrow(() -> {
            String result = input.carNames();
            assertEquals("pobi,woni,jun", result);
        });
    }

    @Test
    @DisplayName("빈 값이 들어왔을 때 오류를 반환하는지 확인")
    void throwErrorsWhenBlankCarNames() {
        setInput("\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.carNames();
        }, "Input is Blank");
    }

    @Test
    @DisplayName("라운드 수가 숫자가 아닐 경우 예외 발생")
    void throwErrorWhenNotNumeric() {
        setInput("abc\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.rounds();
        }, "Round number must be numeric");
    }

    @Test
    @DisplayName("라운드 수가 0일 경우 예외 발생")
    void throwErrorWhenZero() {
        setInput("0\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.rounds();
        }, "Round number must be positive");
    }

    @Test
    @DisplayName("라운드 수가 음수일 경우 예외 발생")
    void throwErrorWhenNegative() {
        setInput("-1\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.rounds();
        }, "Round number must be positive");
    }

    @Test
    @DisplayName("라운드 수가 공백일 경우 예외 발생")
    void throwErrorWhenBlank() {
        setInput(" \n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.rounds();
        }, "Round number must be numeric");
    }

    @Test
    @DisplayName("유효한 라운드 수 입력 시 정상 반환")
    void acceptValidRoundNumber() {
        setInput("3\n");
        assertDoesNotThrow(() -> {
            String result = input.rounds();
            assertEquals("3", result);
        });
    }

    @Test
    @DisplayName("숫자와 문자가 혼합된 경우 예외 발생")
    void throwErrorWhenMixedWithCharacters() {
        setInput("5a\n");
        assertThrows(IllegalArgumentException.class, () -> {
            input.rounds();
        }, "Round number must be numeric");
    }

}