package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.OngoingValue.GO;
import static racingcar.OngoingValue.STOP;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("전진 값")
class GoingValueTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void 숫자가_4_미만이라면_STOP(int number) {
        // when
        OngoingValue value = OngoingValue.from(number);

        // then
        assertThat(value).isEqualTo(STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 숫자가_4_이상이라면_GO(int number) {
        // when
        OngoingValue value = OngoingValue.from(number);

        // then
        assertThat(value).isEqualTo(GO);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 숫자의_값이_0_미만_혹은_9_초과라면_예외(int invalidNumber) {
        // when & then
        assertThatThrownBy(() -> {
            OngoingValue.from(invalidNumber);
        });
    }
}
