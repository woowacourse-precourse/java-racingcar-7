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
        input = new Input();
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
}