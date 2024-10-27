package racingcar.validation;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputHandler;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 개수가 1~100개인지 확인하는 테스트")
    void checkCarCountTest() {
        List<String> tooManyCars = new ArrayList<>();
        List<String> emptyCars = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            tooManyCars.add("car" + i);
        }
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarCount(tooManyCars));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarCount(emptyCars));
    }

    @Test
    @DisplayName("자동차들의 이름이 1~5개인지 확인하는 테스트")
    void checkCarNameLengthTest() {
        List<String> overLengthCarName = new ArrayList<>();
        List<String> noCarName = new ArrayList<>();

        overLengthCarName.add("tooLongCar");
        noCarName.add("");

        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNameLength(overLengthCarName));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNameLength(noCarName));
    }

    @Test
    @DisplayName("자동차의 이름이 영대소문자,숫자로만 이루어져있는지 확인하는 테스트")
    void checkAlphaNumericNameTest() {
        List<String> invalidCarNames = new ArrayList<>();

        invalidCarNames.add("na;me");

        assertThrows(IllegalArgumentException.class, () -> Validator.checkAlphaNumericName(invalidCarNames));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있는지 확인하는 테스트")
    void checkDuplicateNameTest() {
        List<String> duplicateCarNames = new ArrayList<>();

        duplicateCarNames.add("car1");
        duplicateCarNames.add("car1");

        assertThrows(IllegalArgumentException.class, () -> Validator.checkDuplicateName(duplicateCarNames));
    }

    @Test
    @DisplayName("시도횟수가 숫자인지 확인하는 확인하는 테스트")
    void checkNumericTest() {
        String invalidInput = "noNumber";

        assertThrows(IllegalArgumentException.class, () -> Validator.parseToInt(invalidInput));
    }

    @Test
    @DisplayName("시도횟수 범위가 1~100인지 확인하는 테스트")
    void checkCountRangeTest() {
        int tooManyCount = 101;
        int noCount = 0;

        assertThrows(IllegalArgumentException.class, () -> Validator.checkCountRange(tooManyCount));
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCountRange(noCount));
    }
}