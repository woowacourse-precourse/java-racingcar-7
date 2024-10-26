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
    void checkCarNameLength() {
        List<String> overLengthCarName = new ArrayList<>();
        List<String> noCarName = new ArrayList<>();

        overLengthCarName.add("tooLongCar");
        noCarName.add("");

        assertThrows(IllegalArgumentException.class, ()-> Validator.checkCarNameLength(overLengthCarName));
        assertThrows(IllegalArgumentException.class, ()-> Validator.checkCarNameLength(noCarName));
    }
}
