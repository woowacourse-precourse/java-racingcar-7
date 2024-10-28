package racingcar.validator;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void beforeEach() {
        this.inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("자동차 이름에 허용되지 않는 문자가 입력된 경우")
    void 자동차_이름에_허용되지_않는_문자가_입력된_경우() {
        String[] carNames = {"abcd@,abcd"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(carNames),
                "이름에 알파벳, 한글, 숫자 이외의 값이 포함되면 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 최대길이를 넘어간 경우")
    void 자동차_이름의_길이가_최대길이를_넘어간_경우() {
        String[] carNames = {"abcdef,abcde"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(carNames),
                "자동차 이름의 길이가 5를 넘어가면 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름의 입력이 2개 미만인 경우")
    void 자동차_이름의_입력이_2개_미만인_경우() {
        String[] carNames = {"abcdef"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(carNames),
                "자동차 이름의 입력이 2개 미만일 경우 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름의 입력이 100개 초과인 경우")
    void 자동차_이름의_입력이_100개_초과인_경우() {
        String[] carNames = IntStream.range(0, 101)
                .mapToObj(i -> "car" + i)
                .toArray(String[]::new);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(carNames),
                "자동차 이름의 입력이 100개 초과일 경우 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재하는 경우")
    void 자동차_이름에_중복이_존재하는_경우() {
        String[] carNames = {"abcde", "abcde"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(carNames),
                "자동차 이름에 중복이 존재하는 경우 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("시행 횟수에 숫자가 아닌 다른 문자가 포함된 경우")
    void 시행_횟수에_숫자가_아닌_다른_문자가_포함된_경우() {
        String trialCount = "a";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTrialCount(trialCount),
                "시행 횟수가 숫자가 아닌 문자가 입력되면 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("시행 횟수가 1 미만으로 입력된 경우")
    void 시행_횟수가_1_미만으로_입력된_경우() {
        String trialCount = "0";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTrialCount(trialCount),
                "시행 횟수가 1 미만의 숫자이면 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("시행 횟수가 10000 초과로 입력된 경우")
    void 시행_횟수가_10000_초과로_입력된_경우() {
        String trialCount = "10001";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTrialCount(trialCount),
                "시행 횟수가 10000 초과의 숫자이면 예외가 발생해야 합니다.");
    }
}