package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차 이름의 수가 1개 미만이면 예외가 발생한다.")
    @Test
    void validateCarNamesWithCarSizeZero() {
        // given
        String[] carNames = {};

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.CAR_COUNT_ZERO);
    }

    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다.")
    @Test
    void validateCarNamesWithEmptyName() {
        // given
        String[] carNames = {"name1", "name2", ""};

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.CAR_NAME_BLANK);
    }

    @DisplayName("자동차 이름에 공백이거나 비어있으면 예외가 발생한다.")
    @Test
    void validateCarNamesWithBlankName() {
        // given
        String[] carNames = {"name1", "name2", " "};

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.CAR_NAME_BLANK);
    }

    @DisplayName("자동차 이름이 공백 제외 5글자 이상이면 예외가 발생한다.")
    @Test
    void validateCarNamesWithLengthOverName() {
        // given
        String[] carNames = {"가나다라마", "가 나 다 라 마 바"};

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.CAR_NAME_LENGTH_LONG);
    }

    @DisplayName("자동차 이름 배열을 입력받아 검증한다.")
    @Test
    void validateCarNames() {
        // given
        String[] carNames = {"가나다라마", "abcde", "01234", "a b c d e", "가 나 다 라 마"};

        // when & then
        Assertions.assertThatCode(() -> inputValidator.validateCarNames(carNames))
                .doesNotThrowAnyException();

    }
}