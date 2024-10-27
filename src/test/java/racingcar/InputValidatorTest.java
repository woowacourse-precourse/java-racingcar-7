package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {


    @DisplayName("자동차 이름은 5글자를 넘어선 안 된다.")
    @Test
    void 자동차_이름_길이_테스트() {
        // given
        String name = "Maserati";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkNameLen(name);
        });
    }

    @DisplayName("자동차 이름은 최소 1개 입력되어야 한다.")
    @Test
    void 자동차_이름_개수_테스트() {
        // given
        String names = ",,,";
        List<String> carNames = Arrays.stream(names.split(","))
                .filter(name -> !name.trim().isEmpty())
                .collect(Collectors.toList());
        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkCarCount(carNames);
        });
    }

    @DisplayName("시도 횟수는 양수이면서, Long 타입의 범위를 넘어서면 안 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"-3", "99999999999999999999"})
    void 시도_횟수_입력_테스트(String numOfStages) {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isRightNumber(numOfStages);
        });
    }
}
