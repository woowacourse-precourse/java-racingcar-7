package racingcar.domain.race;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceCountTest {

    @Nested
    class RaceCount_검증_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {"hello,world!", "1.2"})
        void 이동_횟수가_정수가_아닐_경우_예외_발생(String raceCount) {
            assertThatThrownBy(() -> RaceCount.from(raceCount))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0","-1", "9999999999"})
        void 이동_횟수가_범위_내의_값이_아닐_경우_예외_발생(String raceCount) {
            assertThatThrownBy(() -> RaceCount.from(raceCount))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
