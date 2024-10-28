package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @DisplayName("게임이 진행되는 동안 가장 많이 움직인 차가 우승자이다.")
    @Test
    void 우승자_확인_총괄_테스트() {
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

        List<String> winners = gameCarProcess.findWinner();
        assertThat(winners).hasSize(1).containsExactly("java");
    }

    @DisplayName("공동 우승자를 확인한다.")
    @Test
    void 공동_우승자_확인_테스트() {
        String firstname = "pobi";
        GameCar firstGameCar = new GameCar(firstname);
        String secondName = "java";
        GameCar secondGameCar = new GameCar(secondName);
        String thirdName = "yi";
        GameCar thirdGameCar = new GameCar(thirdName);
        firstGameCar.move(5);
        secondGameCar.move(5);
        thirdGameCar.move(5);

        List<GameCar> gameCarList = new ArrayList<>();
        gameCarList.add(firstGameCar);
        gameCarList.add(secondGameCar);
        gameCarList.add(thirdGameCar);

        GameCarProcess gameCarProcess = new GameCarProcess(gameCarList, 1);

        List<String> winners = gameCarProcess.findWinner();
        assertThat(winners).hasSize(3).containsExactly("pobi", "java", "yi");
    }

    @DisplayName("단독 우승자를 확인한다.")
    @Test
    void 단독_우승자_확인_테스트() {
        String firstname = "pobi";
        GameCar firstGameCar = new GameCar(firstname);
        String secondName = "java";
        GameCar secondGameCar = new GameCar(secondName);
        String thirdName = "yi";
        GameCar thirdGameCar = new GameCar(thirdName);
        firstGameCar.move(2);
        secondGameCar.move(3);
        thirdGameCar.move(5);

        List<GameCar> gameCarList = new ArrayList<>();
        gameCarList.add(firstGameCar);
        gameCarList.add(secondGameCar);
        gameCarList.add(thirdGameCar);

        GameCarProcess gameCarProcess = new GameCarProcess(gameCarList, 1);

        List<String> winners = gameCarProcess.findWinner();
        assertThat(winners).hasSize(1).containsExactly("yi");
    }
}