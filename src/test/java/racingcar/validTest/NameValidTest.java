package racingcar.validTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;
import racingcar.valid.NameValid;

import java.util.Arrays;
import java.util.List;

class NameValidTest {
    @Test
    @DisplayName("올바른 이름 형식 테스트")
    void validNameFormat() {
        Assertions.assertDoesNotThrow(() ->
                NameValid.checkNamesInput("pobi,woni,jun")
        );
    }

    @Test
    @DisplayName("잘못된 이름 형식 테스트")
    void invalidNameFormat() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkNamesInput("pobi,,woni")
        );
        Assertions.assertEquals(ExceptionMessage.INVALID_NAME_FORMAT, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 수 범위 테스트")
    void carCountRange() {
        // 최소 개수 미만
        IllegalArgumentException under = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkNameCount(0)
        );
        Assertions.assertEquals(ExceptionMessage.CAR_COUNT_UNDER, under.getMessage());

        // 최대 개수 초과
        IllegalArgumentException over = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkNameCount(101)
        );
        Assertions.assertEquals(ExceptionMessage.CAR_COUNT_OVER, over.getMessage());

        // 정상 범위
        Assertions.assertDoesNotThrow(() ->
                NameValid.checkNameCount(50)
        );
    }

    @Test
    @DisplayName("개별 이름 유효성 테스트")
    void checkNameValidation() {
        // 올바른 이름
        Assertions.assertDoesNotThrow(() ->
                NameValid.checkName("pobi")
        );

        // 잘못된 문자 포함
        IllegalArgumentException invalidChar = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkName("!@#")
        );
        Assertions.assertEquals(ExceptionMessage.INVALID_NAME_CHARACTER, invalidChar.getMessage());

        // 길이 초과
        IllegalArgumentException tooLong = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkName("pobiii")
        );
        Assertions.assertEquals(ExceptionMessage.NAME_LENGTH_OVER, tooLong.getMessage());
    }

    @Test
    @DisplayName("이름 중복 체크 테스트")
    void checkNameDuplicationTest() {
        // 중복이 없는 경우
        List<String> validNames = Arrays.asList("pobi", "woni", "jun");
        Assertions.assertDoesNotThrow(() ->
                NameValid.checkNameDuplication(validNames)
        );

        // 중복이 있는 경우
        List<String> duplicateNames = Arrays.asList("pobi", "woni", "pobi");
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NameValid.checkNameDuplication(duplicateNames)
        );
        Assertions.assertEquals(ExceptionMessage.DUPLICATE_NAME, exception.getMessage());
    }
}