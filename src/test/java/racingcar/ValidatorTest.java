package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.Validator;

public class ValidatorTest {
    @Test
    @DisplayName("자동차의 이름이 빈칸일 경우 예외가 발생한다")
    void check_name_empty() {
        String name = "";
        assertThatThrownBy(() -> Validator.isEmpty(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자 가 넘을 경우 예외가 발생한다")
    void check_name_range() {
        String name = "namerangefiveover";
        assertThatThrownBy(() -> Validator.isCarNameRange(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 중복될 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideDuplicateCarNames")
    void validate_Duplicate(List<String> inputs){
        assertThatThrownBy(() -> Validator.containDuplicate(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자외에 입력값이 들어가면 예외가 발생한다")
    void check_tryCount_nonNumeric(){
        String tryCount = "nonNumeric";
        assertThatThrownBy(() -> Validator.validateNumericInput(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수에 음수를 입력하면 예외가 발생한다")
    void check_tryCount_negative(){
        int tryCount = -1;
        assertThatThrownBy(() -> Validator.isNegative(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수에 0를 입력하면 예외가 발생한다")
    void check_tryCount_zero(){
        int tryCount = 0;
        assertThatThrownBy(() -> Validator.isZero(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> provideDuplicateCarNames() {
        return Stream.of(
                Arrays.asList("pobi", "pobi", "kiriko"),
                Arrays.asList("alice", "bob", "alice"),
                Arrays.asList("john", "doe", "john")
        );
    }




}
