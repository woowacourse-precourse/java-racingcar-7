package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;
    private PrintStream standardOut;

    @BeforeEach
    public void setUp() {
        this.inputView = new InputView();
        this.standardOut = System.out;
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 주어진 문자열을 입력으로 설정
    }


    @Test
    void 자동차_이름은_2개_이상() {
        setInput("pobi\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputView.receiveCarNames());
        assertEquals("자동차 이름은 2개 이상 입력해야 합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_빈_문자열_불가() {
        setInput("pobi,,woni\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputView.receiveCarNames());
        assertEquals("자동차 이름은 빈 문자열일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_5자_이하() {
        setInput("pobi,woniiiiii\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputView.receiveCarNames());
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_중복_불가() {
        setInput("pobi,woni,woni\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputView.receiveCarNames());
        assertEquals("자동차 이름은 중복될 수 없습니다.", exception.getMessage());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        Console.close();
    }
}
