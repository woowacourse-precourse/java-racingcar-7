package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrackTest {

    @Test
    void 트랙이_진행중이면_TRUE를_반환한다() {
        //given
        Track track = new Track(5);

        //when
        boolean actual = track.isLapInProgress();

        //then
        assertTrue(actual);
    }

    @Test
    void 트랙이_비진행중이면_FALSE를_반환한다() {
        //given
        Track track = new Track(0);

        //when
        boolean actual = track.isLapInProgress();

        //then
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000})
    void 트랙의_횟수가_1회_이상이면_예외가_발생하지_않는다(int lap) {
        assertDoesNotThrow(() -> Track.from(lap));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 트랙의_횟수가_최소값_보다_작으면_예외가_발생한다(int lap) {
        assertThatThrownBy(() -> Track.from(lap))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 1회 이상 횟수를 입력해주세요.");
    }

}