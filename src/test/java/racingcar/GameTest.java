package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {
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

    @Test
    void Game_play_test() {
        List<String> carNameList = Arrays.asList("pobi", "woni");
        Game test = new Game(carNameList, 3);
        test.play();
        test.play();
        test.play();
        RacingCar pobi = test.racingCarList.getFirst();
        assertThat(pobi.getCount()).isBetween(0, 3);
    }

    @Test
    void Game_generateRacingCarList_exception_test() {
        List<String> carNameList = Arrays.asList("pobi", "javaji");
        assertThatThrownBy(() -> Game.generateRacingCarList(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
