package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRoundHistoryTest {

    @DisplayName("시도 횟수마다 결과값 저장하기 테스트_storeGameRoundHistory")
    @Test
    void Every_Game_Round_Result_Store_Test() {
        GameRoundHistory gameRoundHistory = new GameRoundHistory();
        List<String> carNames = List.of("car1", "car2", "car3");
        RacingCarGame racingCarGame = new RacingCarGame(carNames);

        List<Integer> moves = List.of(3, 5, 6);
        racingCarGame.moveEachCars(moves);

        gameRoundHistory.storeGameRoundHistory(RacingCarsGroup.getCars());

        String expectedResult = "car1 : \n" + "car2 : -\n" + "car3 : -\n" + "\n";
        assertEquals(expectedResult, GameRoundHistory.getEachRoundResult());

    }

    @DisplayName("최종 우승자 테스트_storeFinalWinners")
    @Test
    void Final_Winners_Result_Store_Test() {
        GameRoundHistory gameRoundHistory = new GameRoundHistory();
        List<String> carNames = List.of("car1", "car2", "car3");
        RacingCarGame racingCarGame = new RacingCarGame(carNames);

        List<Integer> moves = List.of(3, 5, 6);
        racingCarGame.moveEachCars(moves);

        gameRoundHistory.storeFinalWinners(RacingCarsGroup.getFinalWinners(RacingCarsGroup.getCars()));

        String expectedResult = "car2, car3";
        assertEquals(expectedResult, GameRoundHistory.getFinalResult());

    }
}
