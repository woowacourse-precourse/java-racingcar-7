package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.TestConstants.CAR_NAME_5;
import static racingcar.TestConstants.CAR_NAME_BLANK;
import static racingcar.TestConstants.CAR_NAME_JUN;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_UP_5;
import static racingcar.TestConstants.CAR_NAME_WONI;
import static racingcar.TestConstants.GAME_COUNT_NEGATIVE;
import static racingcar.TestConstants.GAME_COUNT_NON_INTEGER;
import static racingcar.TestConstants.GAME_COUNT_NON_NUMERIC;
import static racingcar.TestConstants.GAME_COUNT_POSITIVE;
import static racingcar.TestConstants.GAME_COUNT_ZERO;
import static racingcar.common.Constants.DUPLICATED_CAR_NAMES;
import static racingcar.common.Constants.INVALID_CAR_NAME;
import static racingcar.common.Constants.INVALID_GAME_COUNT;
import static racingcar.service.ValidationService.validateCarName;
import static racingcar.service.ValidationService.validateCarNameDuplicate;
import static racingcar.service.ValidationService.validateGameCount;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationServiceTest {
    @Test
    @DisplayName("차 이름은 모두 다르다.")
    void CarNameUnique () {
        // given
        List<String> uniqueCarNames = new ArrayList<>();
        uniqueCarNames.add(CAR_NAME_POBI);
        uniqueCarNames.add(CAR_NAME_WONI);
        uniqueCarNames.add(CAR_NAME_JUN);

        // when & then
        validateCarNameDuplicate(uniqueCarNames);

    }

    @Test
    @DisplayName("차 이름은 중복될 수 없다.")
    void cannotCarNameDuplicate () {
        // given
        List<String> duplicatedCarNames = new ArrayList<>();
        duplicatedCarNames.add(CAR_NAME_POBI);
        duplicatedCarNames.add(CAR_NAME_WONI);
        duplicatedCarNames.add(CAR_NAME_POBI);

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateCarNameDuplicate(duplicatedCarNames);
        });

        assertEquals(DUPLICATED_CAR_NAMES, exception.getMessage());

    }

    @Test
    @DisplayName("모두 유효한 차 이름을 가진다.")
    void validCarName () {
        // given
        String validCarName = CAR_NAME_5;

        // when & then
        validateCarName(validCarName);

    }

    @Test
    @DisplayName("차 이름은 비어 있을 수 없다.")
    void cannotCarNameBlank () {
        // given
        String blankCarName = CAR_NAME_BLANK;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateCarName(blankCarName);
        });

        assertEquals(INVALID_CAR_NAME, exception.getMessage());
    }

    @Test
    @DisplayName("차 이름은 5자를 초과할 수 없다.")
    void cannotCarNameUp5 () {
        // given
        String invalidCarName = CAR_NAME_UP_5;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateCarName(invalidCarName);
        });

        assertEquals(INVALID_CAR_NAME, exception.getMessage());
    }

    @Test
    @DisplayName("게임 횟수에 양수가 입력된 경우, 오류가 나지 않는다.")
    void gameCountIsPositive () {
        // given
        String rawGameCount = GAME_COUNT_POSITIVE;

        // when
        validateGameCount(rawGameCount);

    }

    @Test
    @DisplayName("게임 횟수는 숫자가 입력되어야 한다.")
    void gameCountIsNumeric () {
        // given
        String rawGameCount = GAME_COUNT_NON_NUMERIC;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateGameCount(rawGameCount);
        });

        assertEquals(INVALID_GAME_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("게임 횟수는 정수가 입력되어야 한다.")
    void gameCountIsInteger () {
        // given
        String rawGameCount = GAME_COUNT_NON_INTEGER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateGameCount(rawGameCount);
        });

        assertEquals(INVALID_GAME_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("게임 횟수는 양수가 입력되어야 한다.")
    void gameCountIsNotNegative () {
        // given
        String rawGameCount = GAME_COUNT_NEGATIVE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateGameCount(rawGameCount);
        });

        assertEquals(INVALID_GAME_COUNT, exception.getMessage());
    }

    @Test
    @DisplayName("게임 횟수는 0이 입력되면 안된다.")
    void gameCountIsNotZero () {
        // given
        String rawGameCount = GAME_COUNT_ZERO;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateGameCount(rawGameCount);
        });

        assertEquals(INVALID_GAME_COUNT, exception.getMessage());
    }
}