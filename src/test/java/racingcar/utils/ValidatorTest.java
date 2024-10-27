package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    public void 이름_검증_성공() {
        final String inputNames = "hana,min,aria";

        List<String> names = splitName(inputNames);

        assertThatCode(() -> validator.validateNames(names))
                .doesNotThrowAnyException();
    }

    @Test
    public void 반복횟수_검증_성공() {
        final String inputCount = "4";
        int result = validator.validateCount(inputCount);

        assertThat(result)
                .isEqualTo(Integer.parseInt(inputCount));
    }

    @Test
    public void 이름_5자_초과_입력() {
        final String inputNames = "hana,min,ariana";

        List<String> names = splitName(inputNames);

        assertThatThrownBy(() -> validator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_OVER_LIMIT.getMessage());
    }

    @Test
    public void 이름_중복_입력() {
        final String inputNames = "hana,min,hana";

        List<String> names = splitName(inputNames);

        assertThatThrownBy(() -> validator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_NAME.getMessage());
    }

    @Test
    public void 이름_공백_입력() {
        final String inputNames = "hana,,hana";

        List<String> names = splitName(inputNames);

        assertThatThrownBy(() -> validator.validateNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    public void 반복횟수_숫자_아닌_입력() {
        final String inputCount = "a";

        assertThatThrownBy(() -> validator.validateCount(inputCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COUNT_NOT_NUMBER.getMessage());
    }

    private List<String> splitName(String inputNames) {
        List<String> names = new ArrayList<>();
        Arrays.stream(inputNames.split(Constants.COMMA))
                .forEach(name -> names.add(name));
        return names;
    }
}
