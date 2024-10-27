package racingcar.view.input.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import racingcar.constant.errormessage.ErrorMessage;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.create.RacingCarFactory;
import racingcar.trynumber.domain.TryNumber;
import racingcar.trynumber.service.TryNumberFactory;
import racingcar.view.input.handler.impl.InputHandler;
import racingcar.view.input.service.InputService;
import racingcar.view.input.service.impl.CarInputView;
import racingcar.view.input.validator.racingcar.RacingCarValidator;
import racingcar.view.input.validator.trynumber.TryNumberValidator;

import java.util.List;
import java.util.Set;

public class InputViewTest {
    @Test
    void carInputTest() {
        String testSentence = "pobi,woni,jun";
        InputHandlerService inputHandlerService = new InputHandler(new CarInputTest(testSentence));
        RacingCarInfo racingCarInfo = inputHandlerService.receive(RacingCarFactory::create);
        assertThat(racingCarInfo.getRacingCarInfo()).isEqualTo(List.of(
                RacingCar.of("pobi"),
                RacingCar.of("woni"),
                RacingCar.of("jun")));
    }

    @Test
    @DisplayName("공백이 앞에 있을 경우")
    void isStartWithBlankTest() {
        List<String> sentenceInfo = List.of(" pobi,woni,jun", "pobi, woni,jun","pobi,woni, jun");
        for (String sentence : sentenceInfo) {
            assertThatThrownBy(() -> new InputHandler(new CarInputTest(sentence)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.REGEX_ERROR);
        }
    }

    @Test
    @DisplayName("공백이 뒤에 있을 경우")
    void isEndWithBlankTest() {
        List<String> sentenceInfo = List.of("pobi ,woni,jun", "pobi,woni ,jun","pobi,woni,jun ");
        for (String sentence : sentenceInfo) {
            assertThatThrownBy(() -> new InputHandler(new CarInputTest(sentence)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.REGEX_ERROR);
        }
    }

    @Test
    @DisplayName("공백이 구분자(,) 앞에 있을 경우")
    void isStartWithBlankBySeparator() {
        List<String> sentenceInfo = List.of("poby ,woni,jun", "poby,woni ,jun");
        for (String sentence : sentenceInfo) {
            assertThatThrownBy(() -> new InputHandler(new CarInputTest(sentence)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.REGEX_ERROR);
        }
    }

    @Test
    @DisplayName("공백이 구분자(,) 뒤에 있을 경우")
    void isEndWithBlankBySeparator() {
        List<String> sentenceInfo = List.of(
                "poby, woni,jun", "poby,woni, jun"
        );
        for (String sentence : sentenceInfo) {
            assertThatThrownBy(() -> new InputHandler(new CarInputTest(sentence)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.REGEX_ERROR);
        }
    }

    @Test
    @DisplayName(",이 뒤에 있을 경우")
    void isEndWithCommaTest() {
        String testSentence = "pobi,woni,";
        assertThatThrownBy(() -> new InputHandler(new CarInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName(",이 앞에 있을 경우")
    void isStartWithCommaTest() {
        String testSentence = ",pobi,jun";
        assertThatThrownBy(() -> new InputHandler(new CarInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("구분자(,) 이중으로 나올 경우")
    void isDoubleCommaSeparator() {
        List<String> sentenceInfo = List.of("pobi,,woni,jun", "pobi,woni,,jun");
        for (String sentence : sentenceInfo) {
            assertThatThrownBy(() -> new InputHandler(new CarInputTest(sentence)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.REGEX_ERROR);
        }
    }

    @Test
    @DisplayName("자동차 입력이 2개 이상이 아닐 경우")
    void isCarInputsNotTwoORMoreTest() {
        String testSentence = "pobi";
        assertThatThrownBy(() -> new InputHandler(new CarInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("구분자가 들어올 경우, 사이에 공백이 들어 올 경우")
    void isCommaExceptionSeparatorTest() {
        List<String> sentenceInfo = List.of("mark_1,mark_2,@#13", "_1mark2,mark_2,.@#13","____2,m__32k_2,.@#13", "1  3,4  5,6   7");
        for (String sentence : sentenceInfo) {
            new InputHandler(new CarInputTest(sentence));
        }
    }

    @Test
    @DisplayName("공백만 있을 경우")
    void isBlankTest() {
        String testSentence = "";
        assertThatThrownBy(() -> new InputHandler(new CarInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("TryNumber 테스트")
    void tryNumberInputTest() {
        String testSentence = "21345678";
        InputHandlerService inputHandlerService = new InputHandler(new TryNumberInputTest(testSentence));
        TryNumber tryNumber = inputHandlerService.receive(TryNumberFactory::create);
        assertThat(tryNumber.getCount()).isEqualTo(21345678);
    }

    @Test
    @DisplayName("숫자외의 값이 들어 올 경우")
    void isNoneDigitTest() {
        String testSentence = "s1231451423";
        assertThatThrownBy(() -> new InputHandler(new TryNumberInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("0만 있을 경우")
    void isZeroTest() {
        String testSentence = "0";
        assertThatThrownBy(() -> new InputHandler(new TryNumberInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("0이 먼저 올 경우")
    void isStartZeroTest() {
        String testSentence = "01234";
        assertThatThrownBy(() -> new InputHandler(new TryNumberInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("음수가 올 경우")
    void isNegativeInteger() {
        String testSentence = "-1";
        assertThatThrownBy(() -> new InputHandler(new TryNumberInputTest(testSentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("정수형 범위를 넘었을 경우")
    void integerMaxValue() {
        String sentence = "2147483648";
        assertThatThrownBy(() -> new InputHandler(new TryNumberInputTest(sentence)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_MAX_VALUE_ERROR);

    }

}

class CarInputTest implements InputService {
    private final String inputTest;

    public CarInputTest(String inputTest) {
        RacingCarValidator.validator(inputTest);
        this.inputTest = inputTest;
    }

    @Override
    public String input() {
        return inputTest;
    }
}

class TryNumberInputTest implements InputService {
    private final String inputTest;

    public TryNumberInputTest(String inputTest) {
        TryNumberValidator.validator(inputTest);
        this.inputTest = inputTest;
    }

    @Override
    public String input() {
        return inputTest;
    }
}