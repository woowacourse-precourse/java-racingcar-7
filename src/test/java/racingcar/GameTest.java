package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @DisplayName("[정상 테스트]Game.generateRacingCarList - RacingCar 인스턴스의 이름이 입력값과 동일")
    @Test
    void Game_generateRacingCarList_test() {
        List<String> carNameList = Arrays.asList("pobi", "woni");
        List<RacingCar> carInstanceList = Game.generateRacingCarList(carNameList);

        RacingCar pobi = carInstanceList.get(0);
        RacingCar woni = carInstanceList.get(1);

        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(pobi.getCount()).isEqualTo(0);
        assertThat(woni.getName()).isEqualTo("woni");
        assertThat(woni.getCount()).isEqualTo(0);
    }

    @DisplayName("[정상 테스트]Game.playOneRound - 자동차의 전진거리가 playOneRound()의 호출 횟수를 넘지 않음")
    @Test
    void Game_playOneRound_test() {
        List<String> carNameList = Arrays.asList("pobi", "woni");
        Game test = new Game(carNameList, 3);
        test.playOneRound();
        test.playOneRound();
        test.playOneRound();

        RacingCar pobi = test.racingCarList.get(0);
        RacingCar woni = test.racingCarList.get(1);
        assertThat(pobi.getCount()).isBetween(0, 3);
        assertThat(woni.getCount()).isBetween(0, 3);
    }

    @DisplayName("[정상 테스트]Game.findWinner - 우승자가 한 명")
    @Test
    void Game_findWinner_one_test() {
        List<String> carNameList = Arrays.asList("pobi", "woni");
        Game test = new Game(carNameList, 3);

        RacingCar pobi = test.racingCarList.get(0);
        RacingCar woni = test.racingCarList.get(1);
        while (woni.getCount() < pobi.getCount()) {
            test.playOneRound();
        }
        assertThat(test.findWinners()).contains("pobi");
    }

    @DisplayName("[정상 테스트]Game.findWinner - 공동 우승자")
    @Test
    void Game_findWinner_joint_test() {
        List<String> carNameList = Arrays.asList("pobi", "woni");
        Game test = new Game(carNameList, 3);

        RacingCar pobi = test.racingCarList.get(0);
        RacingCar woni = test.racingCarList.get(1);
        while (woni.getCount() != 0 && woni.getCount() == pobi.getCount()) {
            test.playOneRound();
        }
        assertThat(test.findWinners()).contains("pobi");
        assertThat(test.findWinners()).contains("woni");
    }

    @DisplayName("[예외 테스트]Game.generateRacingCarList - 입력된 이름이 5자 초과")
    @Test
    void Game_generateRacingCarList_longName_exception_test() {
        List<String> carNameList = Arrays.asList("pobi", "javaji");
        assertThatThrownBy(() -> Game.generateRacingCarList(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외 테스트]Game.generateRacingCarList - 입력된 이름이 빈 문자열")
    @Test
    void Game_generateRacingCarList_emptyName_exception_test() {
        List<String> carNameList = Arrays.asList("pobi", "");
        assertThatThrownBy(() -> Game.generateRacingCarList(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
