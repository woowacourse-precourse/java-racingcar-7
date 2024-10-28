package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.car.Car;
import racingcar.game.winner.WinnerStub;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameLogFormatterTest {

    private final RacingGameLogFormatter logFormatter = new RacingGameLogFormatter();

    @Test
    @DisplayName("자동차 로그 포맷팅")
    void test() {
        Car car = new Car("pobi", 4);

        String result = logFormatter.formatCar(car);

        assertEquals("pobi : ----", result);
    }

    @Test
    @DisplayName("우승자 포맷팅")
    void test1() {
        WinnerStub mockWinner = new WinnerStub();
        mockWinner.setTestValue(List.of("pobi", "kkk"));

        String result = logFormatter.formatWinner(mockWinner);

        assertEquals("최종 우승자 : pobi, kkk", result);
    }
}