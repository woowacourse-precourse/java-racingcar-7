package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class CarNameValidatorTest {

    @DisplayName("구분자를 쉼표가 아닌 다른 문자를 사용한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni", "pobi-woni-jun"})
    void validateSeparator(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.ONLY_COMMA.getMessage(), exception.getMessage());
    }

    @DisplayName("입력의 시작이 쉼표(,)인 경우")
    @ParameterizedTest
    @ValueSource(strings = {",pobi.woni", ",pobi-woni-jun"})
    void validateStartSeparator(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_FRONT_COMMA.getMessage(), exception.getMessage());
    }

    @DisplayName("입력의 마지막이 쉼표(,)인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni,", "pobi-woni-jun,"})
    void validateBackSeparator(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_BACK_COMMA.getMessage(), exception.getMessage());
    }

    @DisplayName("입력이 없는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void validateNull(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_NULL.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름이 5글자를 초과할 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pooobi,woni", "pobi,woonii"})
    void validateNameOverFive(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCar(input);
        });

        Assertions.assertEquals(ErrorMessage.NAME_LENGTH_ONE_TO_FIVE.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름 위치에 공백을 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, ,woni", "pobi, ,woni, kim"})
    void validateNameIsBlank(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCar(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름에 공백, 영어, 숫자, 한글을 제외한 문자가 포함된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"poB#,우니", "p0b1,우.1"})
    void validateNameCondition(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCar(input);
        });

        Assertions.assertEquals(ErrorMessage.CAR_NAME_CONDITION.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름이 중복된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,pobi", "pobi,woni,woni"})
    void validateNameDuplication(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCar(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION.getMessage(), exception.getMessage());
    }

    @DisplayName("경기에 참여하는 자동차의 수가 2대 이상이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void validateCarUnderTwo(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCar(input);
        });

        Assertions.assertEquals(ErrorMessage.MIN_CAR_COUNT.getMessage(), exception.getMessage());
    }
}