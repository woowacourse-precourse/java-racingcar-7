package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTraceTest {
    RacingCar rc1;
    RacingCar rc2;
    RacingCarTrace racingCarTrace;

    @BeforeEach
    void setUp() {
        rc1 = new RacingCar("abc");
        rc2 = new RacingCar("bcd");

        racingCarTrace = new RacingCarTrace();

        racingCarTrace.put(rc1);
        racingCarTrace.put(rc2);
    }

    @Test
    void put_정상흐름() {
        assertEquals(2, racingCarTrace.size());
    }

    @Test
    void size_확인() {
        assertEquals(2, racingCarTrace.size());
    }

    @Test
    void put시_중복된_이름_있을시_에러발생() {
        RacingCar rc3 = new RacingCar("abc");
        RacingCar rc4 = new RacingCar("abc");

        assertThatThrownBy(() -> {
            racingCarTrace.put(rc3);
            racingCarTrace.put(rc4);
        }).hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    void traceToString_테스트() {
        String trace = racingCarTrace.traceToString();

        assertEquals("abc : \nbcd : \n\n", trace);

        racingCarTrace.forwardOrStop(rc1, 4);
        trace = racingCarTrace.traceToString();

        assertEquals("abc : -\nbcd : \n\n", trace);
    }

    @Test
    void 레이싱카_넣은순서대로_나오는지_확인() {
        RacingCar rc3 = new RacingCar("dfdf");
        RacingCar rc4 = new RacingCar("bc");

        racingCarTrace.put(rc3);
        racingCarTrace.put(rc4);

        assertEquals(rc1, racingCarTrace.getRacingCar(0));
        assertEquals(rc2, racingCarTrace.getRacingCar(1));
        assertEquals(rc3, racingCarTrace.getRacingCar(2));
        assertEquals(rc4, racingCarTrace.getRacingCar(3));
    }

    @Test
    void 이동한거리_확인() {
        int forward = 4;

        IntStream.range(0, 100).forEach(index -> racingCarTrace.forwardOrStop(rc1, forward));

        assertEquals(100, racingCarTrace.getDistance(rc1));
    }

    @Test
    void 가장_긴_이동거리_리스트_확인() {
        int forward = 4;

        IntStream.range(0, 100).forEach(index -> racingCarTrace.forwardOrStop(rc1, forward));
        IntStream.range(0, 100).forEach(index -> racingCarTrace.forwardOrStop(rc2, forward));

        assertEquals(2, racingCarTrace.getBiggestDistanceRacingCar().size());

        RacingCar rc3 = new RacingCar("dfdf");
        RacingCar rc4 = new RacingCar("bc");

        racingCarTrace.put(rc3);
        racingCarTrace.put(rc4);

        IntStream.range(0, 101).forEach(index -> racingCarTrace.forwardOrStop(rc3, forward));

        assertEquals(1, racingCarTrace.getBiggestDistanceRacingCar().size());
    }

    @Test
    void forward_stop_정상흐름() {
        int forward = 4;
        int stop = 3;

        racingCarTrace.forwardOrStop(rc1, forward);
        racingCarTrace.forwardOrStop(rc2, stop);

        assertEquals(1, racingCarTrace.getDistance(rc1));
        assertEquals(0, racingCarTrace.getDistance(rc2));
    }
}