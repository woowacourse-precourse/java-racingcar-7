package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRacingTest {
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
    void 이동거리_제일_큰_레이싱카_반환() {
        IntStream.range(0, 100).forEach(index -> racingCarTrace.forwardOrStop(rc1, 4));

        List<RacingCar> biggestDistanceRacingCar = CarRacing.start(racingCarTrace, 5);

        assertEquals(1, biggestDistanceRacingCar.size());
        assertEquals(rc1, biggestDistanceRacingCar.get(0));
    }
}