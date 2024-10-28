package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.CarNameValidator;

class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    public void setUp() {
        this.carNameValidator = new CarNameValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   ", "     "})
    void 입력값이_공백일때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateBlank(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요힛", "안녕하세요요요", "내이름은안녕하세요", "이름이특이하네요"})
    void 차이름_길이가_5자_이상일때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateMoreThanFive(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"반가워요", "세글자", "이름", "이", "안녕하세요"})
    void 차이름_길이가_5자_이하일때(String userInput) {
        assertDoesNotThrow(() -> {
            carNameValidator.validateMoreThanFive(userInput);
        });
    }

    @Test
    void 차이름이_중복일때() {
        carNameValidator.validCarNames.add("중복이");
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateDuplicate("중복이");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요!구분자가없으면어떻게되나요!느낌표가구분자입니다.", "안녕하세요?구분자가없으면어떻게되죠?"})
    void 차이름에_쉼표가_없을때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateContainComma(userInput);
        });
    }


}

