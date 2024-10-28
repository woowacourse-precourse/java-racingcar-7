package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.validator.carName.CarNameValidatorFacade;
import racingcar.view.validator.racingNumber.RacingNumberValidatorFacade;

public class InputProcessorTest {
    private InputProcessor inputProcessor;
    private PrintStream standardOut;

    @BeforeEach
    public void setUp() {
        CarNameValidatorFacade carNameValidatorFacade = new CarNameValidatorFacade();
        RacingNumberValidatorFacade racingNumberValidatorFacade = new RacingNumberValidatorFacade();
        this.inputProcessor = new InputProcessor(carNameValidatorFacade, racingNumberValidatorFacade);
        this.standardOut = System.out;
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 주어진 문자열을 입력으로 설정
    }

    @Test
    void 자동차_이름은_2개_이상() {
        setInput("pobi\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름은 2개 이상 입력해야 합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_빈_문자열_불가() {
        setInput("pobi,,woni\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름은 빈 문자열일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_5자_이하() {
        setInput("pobi,woniiiiii\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_중복_불가() {
        setInput("pobi,woni,woni\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름은 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_공백_포함_불가() {
        setInput("po bi,woni,jun\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름에는 공백이 포함될 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_구분자_쉼표만_허용() {
        setInput("pobi.woni,jun\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveCarNames());
        assertEquals("자동차 이름 구분자는 쉼표(,)만 가능합니다.", exception.getMessage());
    }

    @Test
    void 경주_횟수_공백_불가() {
        setInput("pobi,woni,jun\n");
        setInput("\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveRacingNumber());
        assertEquals("경주 횟수는 빈 문자열일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 경주_횟수_문자_불가() {
        setInput("pobi,woni,jun\n");
        setInput("char");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveRacingNumber());
        assertEquals("경주 횟수는 숫자이어야 합니다.", exception.getMessage());
    }

    @Test
    void 경주_횟수_0_불가() {
        setInput("pobi,woni,jun\n");
        setInput("0");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveRacingNumber());
        assertEquals("경주 횟수는 1 이상의 숫자이어야 합니다.", exception.getMessage());
    }

    @Test
    void 경주_횟수_음수_불가() {
        setInput("pobi,woni,jun\n");
        setInput("-1");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputProcessor.receiveRacingNumber());
        assertEquals("경주 횟수는 1 이상의 숫자이어야 합니다.", exception.getMessage());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        Console.close();
    }
}
