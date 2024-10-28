package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

class CarGameServiceTest {
    final CarGameService carGameService = new CarGameService();

    @Test
    @DisplayName("모든 우승자가 0점인 경우 - 모두가 우승이라고 판정")
    public void findWinnerWhenAllZeroScoreTest() {
        List<Car> vehicles = new ArrayList<>();
        vehicles.add(new Car("aaa", 0));
        vehicles.add(new Car("bbb", 0));
        vehicles.add(new Car("ccc", 0));

        String result = carGameService.playGames(vehicles, 0);
        String answer = "aaa, bbb, ccc";

        assert result.equals(answer);
    }

    @Test
    @DisplayName("우승자를 출력한다")
    public void findWinnerTest() {
        List<Car> vehicles = new ArrayList<>();
        vehicles.add(new Car("aaa", 0));
        vehicles.add(new Car("bbb", 1));
        vehicles.add(new Car("ccc", 0));

        String result = carGameService.playGames(vehicles, 0);
        String answer = "bbb";

        assert result.equals(answer);
    }
}