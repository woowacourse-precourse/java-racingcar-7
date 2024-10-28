package racingcar.ui.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.UserInputRequester;
import racingcar.ui.StringPrinterDummy;
import racingcar.ui.StringReaderStub;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {

    private InputReader reader;
    private StringReaderStub stubReader;
    private StringPrinterDummy dummyPrinter;
    private UserInputRequester userInputRequester;

    @BeforeEach
    void beforeEach() {
        stubReader = new StringReaderStub();
        dummyPrinter = new StringPrinterDummy();
        userInputRequester = new UserInputRequester(stubReader, dummyPrinter);
        reader = new InputReader(userInputRequester);
    }


    @Test
    @DisplayName("이름을 읽어옴")
    void test1() {
        String names = "pobi,woni,jun";
        stubReader.setMockUserInput(names);

        List<String> result = reader.readNames();

        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("이동 시도 횟수 입력")
    void test3() {
        int movedCnt = 5;
        stubReader.setMockUserInput(String.valueOf(movedCnt));

        int result = reader.readMovementAttempts();
        assertThat(result).isEqualTo(movedCnt);
    }

    @Test
    @DisplayName("숫자로 바꿀 수 없는 문자 입력 시 예외")
    void test4() {
        String onlyString = "ABC";
        stubReader.setMockUserInput(onlyString);

        assertThrows(IllegalArgumentException.class, () -> reader.readMovementAttempts());
    }

}
