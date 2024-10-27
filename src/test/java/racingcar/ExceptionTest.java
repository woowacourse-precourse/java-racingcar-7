package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    private RacingService racingService;

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 에러 발생")
    void 자동차_이름_5글자_초과_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("aaaaaaa,bbbbbbb,ccccccc,ddddddd", "4");
            racingService.startRaceGame();
        });
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우 에러 발생")
    void 자동차_이름_중복_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingService = new RacingService("a,a,b,c,d", "4");
            racingService.startRaceGame();
        });
    }
}
