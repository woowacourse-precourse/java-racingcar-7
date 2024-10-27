package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RacingCarsGroupTest {

    @Test
    @DisplayName("getFinalWinners 메서드 테스트")
    void should_Return_Max_Position_Index_When_Cars_Are_Provided() {
        List<String> cars = List.of("pobi", "woni", "jun");
        List<Integer> moves = List.of(3, 5, 5);

        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.moveEachCars(moves);

        List<Car> carsGroup = RacingCarsGroup.getCars();
        List<Car> winners = RacingCarsGroup.getFinalWinners(carsGroup);

        assertEquals(2, winners.size(), "최종 우승자는 위치가 5인 2개의 자동차여야 한다.");
        assertTrue(winners.stream().anyMatch(car -> "woni".equals(car.getName())), "우승자 목록에 woni가 포함되어야 한다.");
        assertTrue(winners.stream().anyMatch(car -> "jun".equals(car.getName())), "우승자 목록에 jun이 포함되어야 한다.");
    }

}



