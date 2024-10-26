package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @DisplayName("게임이 진행되는 동안 가장 많이 움직인 차가 우승자이다.")
    @Test
    void winnerTest() {
        String firstname = "pobi";
        GameCar firstGameCar = new GameCar(firstname);
        String secondName = "java";
        GameCar secondGameCar = new GameCar(secondName);
        firstGameCar.move(3);
        secondGameCar.move(7);

        List<GameCar> gameCarList = new ArrayList<>();
        gameCarList.add(firstGameCar);
        gameCarList.add(secondGameCar);

        GameCarProcess gameCarProcess = new GameCarProcess(gameCarList, 1);
        gameCarProcess.gameProgress();

        List<String> winners = gameCarProcess.findWinner();
        assertThat(winners).hasSize(1).containsExactly("java");
    }
}