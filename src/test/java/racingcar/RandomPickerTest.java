package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomPickerTest {

    RandomPicker randomPicker = new RandomPicker();

    @Test
    @DisplayName("List<String> carNames가 null이면 IllegalArgumentException이 발생한다.")
    void testRunTotalRandomNull() {
        List<String> carNames = null;
        assertThatThrownBy(() -> randomPicker.runTotalRandom(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("List<String> carNames의 구성원이 1이면 IllegalArgumentException이 발생한다.")
    void testRunTotalRandomOnly() {
        List<String> carNames = Arrays.asList("tubi");
        assertThatThrownBy(() -> randomPicker.runTotalRandom(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    @DisplayName("int totalRounds가 양의 정수가 아니면 IllegalArgumentException이 발생한다.")
    void testRunTotalRandomInt(int totalRounds) {
        List<String> carNames = Arrays.asList("tubi", "po");
        assertThatThrownBy(() -> randomPicker.runTotalRandom(carNames, totalRounds))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, Integer.MIN_VALUE})
    @DisplayName("int randomInt가 0부터 9까지의 정수가 아니면 IllegalArgumentException이 발생한다.")
    void testValidateRandomResult(int randomInt) {
        assertThatThrownBy(() -> randomPicker.validateRandomResult(randomInt))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("int randomInt가 4 이상이면 isCarGoForward == true다.")
    void testMapCarIfForwardTrue(int randomInt) {
        assertThat(randomPicker.validateRandomResult(randomInt))
                .isSameAs(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("int randomInt가 4 미만이면 isCarGoForward == false이다.")
    void testMapCarIfForwardFalse(int randomInt) {
        assertThat(randomPicker.validateRandomResult(randomInt))
                .isSameAs(false);
    }
}
