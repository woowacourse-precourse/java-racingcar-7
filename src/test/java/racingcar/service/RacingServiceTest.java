package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RacingServiceTest {
    private final CarService carService = new CarService();
    private final RacingService racingService = new RacingService(carService);

    @Test
    void 사용자입력_이동횟수_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> racingService.raceStart(0));
        assertThrows(IllegalArgumentException.class, () -> racingService.raceStart(-1));
        assertThrows(IllegalArgumentException.class, () -> racingService.raceStart(21));
    }
}