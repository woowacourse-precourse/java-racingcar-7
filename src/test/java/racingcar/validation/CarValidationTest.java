package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarValidationTest {
    @Test
    void validate_구분자_포함_검증() {
        String input = "pobi,woni";
        String inputNoSeparator = "pobi woni";

        boolean inputResult = CarValidation.validateCarNameSeparator(input);
        boolean inputNoSeparatorResult = CarValidation.validateCarNameSeparator(inputNoSeparator);

        assertThat(inputResult).isFalse();
        assertThat(inputNoSeparatorResult).isTrue();
    }

    @Test
    void validate_자동차_이름_중복_검증() {
        List<String> input = List.of("pobi", "woni");
        List<String> inputDuplication = List.of("pobi", "pobi");

        boolean inputResult = CarValidation.validateCarNameDuplication(input);
        boolean inputDuplicationResult = CarValidation.validateCarNameDuplication(inputDuplication);

        assertThat(inputResult).isFalse();
        assertThat(inputDuplicationResult).isTrue();
    }

    @Test
    void validate_빈_자동차_이름_검증() {
        List<String> input = List.of("pobi", "woni");
        List<String> inputEmpty = List.of("", "pobi");

        boolean inputResult = CarValidation.validateCarNameEmpty(input);
        boolean inputEmptyResult = CarValidation.validateCarNameEmpty(inputEmpty);

        assertThat(inputResult).isFalse();
        assertThat(inputEmptyResult).isTrue();
    }
}
