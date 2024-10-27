package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_NOT_NULL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("입력된 자동차 이름 리스트가 비어 있을 때 예외가 발생한다.")
    void carsEmptyNamesExceptionHandling() {
        List<String> emptyList = List.of();

        assertThatThrownBy(() -> new Cars(emptyList))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_NOT_NULL.message);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 중복이 있을 때 예외가 발생한다.")
    void carsDuplicateExceptionHandling() {
        List<String> duplicateList = new ArrayList<>();
        duplicateList.add("ihhoCar");
        duplicateList.add("ihhoCar");

        assertThatThrownBy(() -> new Cars(duplicateList))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_DUPLICATE.message);
    }
}
