package custom;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import custom.validator.InputValidator;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 유효성검증기능_입력이NULL일때_테스트() {
        assertThatThrownBy(() -> inputValidator.checkEmptyInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null 일 수 없습니다");
    }

    @Test
    void 유효성검증기능_입력이빈문자열일때_테스트() {
        assertThatThrownBy(() -> inputValidator.checkEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 문자열 일 수 없습니다");
    }

    @Test
    void 유효성검증기능_입력이공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> inputValidator.checkEmptyInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 공백으로만 구성될 수 없습니다");
    }

    @Test
    void 유효성검증기능_자동차대수판별_테스트() {
        assertThatThrownBy(() -> inputValidator.checkNumberOfCars(Arrays.asList("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 2대 미만 입력되었습니다");
    }

    @Test
    void 유효성검증기능_자동차이름길이검증_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNamesForLength(Arrays.asList("pobi", "longCarName")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 5자를 초과하는 이름이 있습니다");
    }

    @Test
    void 유효성검증기능_자동차이름중복여부검증_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNamesForDuplicateNames(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 중복된 이름이 있습니다");
    }

    @Test
    void 유효성검증기능_자동차이름공백여부검증_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNamesForSpaces(Arrays.asList("pobi", "ju n")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 공백이 포함된 이름이 있습니다");
    }

    @Test
    void 유효성검증기능_자동차이름구성문자검증_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNamesForInvalidCharacters(Arrays.asList("pobi", "123")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름은 알파벳이나 한글로 작성되어야 합니다.");
    }
}