package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.validator.RacingCarListValidator;

class RaceCarListValidatorTest {

    private RacingCarListValidator racingCarListValidator;

    @BeforeEach
    void setUp() {
        racingCarListValidator = new RacingCarListValidator();
    }

    @Test
    @DisplayName("리스트에 중복 요소가 존재하여 예외가 발생한다.")
    void validateDuplicateTest() throws Exception {
        //given
        final List<String> values = List.of("자동차", "자동차", "자동차");

        //when
        //then
        assertThatThrownBy(() -> racingCarListValidator.validateDuplicate(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("리스트의 사이즈가 최대 범위를 초과하여 예외가 발생한다.")
    void validateRangeTest() throws Exception {
        //given
        final int maxRange = 3;
        final List<String> values = List.of("자동차1", "자동차2", "자동차3", "자동차4", "자동차5");

        //when
        //then
        assertThatThrownBy(() -> racingCarListValidator.validateSize(values, maxRange))
                .isInstanceOf(IllegalArgumentException.class);

    }

}