package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}