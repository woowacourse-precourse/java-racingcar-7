package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.MapBuilder.forwardCounter;
import static racingcar.MapBuilder.lineCounter;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomPickerTest {

    @Test
    @DisplayName("List<String> carNames가 null이면 IllegalArgumentException이 발생한다.")
    void testRunRandomRoundsNull() {
        List<String> carNames = null;
        assertThatThrownBy(() -> RandomPicker.runRandomRounds(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("List<String> carNames의 구성원이 1이면 IllegalArgumentException이 발생한다.")
    void testRunRandomRoundsOnly() {
        List<String> carNames = Arrays.asList("tubi");
        assertThatThrownBy(() -> RandomPicker.runRandomRounds(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-1,Integer.MIN_VALUE})
    @DisplayName("int totalRounds가 양의 정수가 아니면 IllegalArgumentException이 발생한다.")
    void testRunRandomRoundsInt(int totalRounds) {
        List<String> carNames = Arrays.asList("tubi", "po");
        assertThatThrownBy(() -> RandomPicker.runRandomRounds(carNames, totalRounds))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,10, Integer.MIN_VALUE})
    @DisplayName("int randomInt가 0부터 9까지의 정수가 아니면 IllegalArgumentException이 발생한다.")
    void testValidateRandomResult(int randomInt) {
        assertThatThrownBy(() -> RandomPicker.validateRandomResult(randomInt))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("int randomInt가 4 이상이면 isCarGoForward == true다.")
    void testMapCarIfForward(int randomInt) {
        assertThat(RandomPicker.validateRandomResult(randomInt))
                .isSameAs(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("int randomInt가 4 미만이면 isCarGoForward == false이다.")
    void testMapCarIfForwardNo(int randomInt) {
        assertThat(RandomPicker.validateRandomResult(randomInt))
                .isSameAs(false);
    }

}
