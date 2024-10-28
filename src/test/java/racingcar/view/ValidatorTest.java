package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    @DisplayName("자동차 이름의 길이가 범위에 맞지 않으면 예외")
    void checkCarNameLength() {
        //given
        String inputNames = "pobiii,woni,jun";

        //when //then
        assertThatThrownBy(() -> validator.validateCarNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 최대길이는 5글자 입니다");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외")
    void checkDuplicateCarName() {
        //given
        String inputNames = "pobi,pobi,woni";

        //when //then
        assertThatThrownBy(() -> validator.validateCarNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외")
    void checkBlankCarName() {
        //given
        String inputNames = "pobi,  ,woni";

        //when //then
        assertThatThrownBy(() -> validator.validateCarNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 허용하지 않습니다");
    }

    @Test
    @DisplayName("자동차 이름이 입력되지 않으면 예외")
    void checkEmptyCarName() {
        //given
        String inputNames = "pobi,,woni";

        //when //then
        assertThatThrownBy(() -> validator.validateCarNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 허용하지 않습니다");
    }

    @Test
    @DisplayName("정해진 구분자를 사용하지 않으면 예외")
    void checkDelimiter() {
        //given
        String inputNames = "pobi;woni;jun";

        //when //then
        assertThatThrownBy(() -> validator.validateCarNames(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자를 사용하였습니다");
    }

    @Test
    @DisplayName("숫자외의 값이 들어오면 예외")
    void checkNumeric() {
        //given
        String inputCount = "5a";

        //when //then
        assertThatThrownBy(() -> validator.validateRoofCount(inputCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력될 수 있습니다");
    }
}