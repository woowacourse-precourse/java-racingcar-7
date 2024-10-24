package racingcar;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameCreateCarTest {
    public RacingGame racingGame;

    @BeforeEach
    public void init() {
        racingGame = new RacingGame();
    }

    @Test
    public void 차생성테스트() throws Exception {
        //given
        String[] names = racingGame.createName("pobi,woni,jun");
        //when
        ArrayList<Car> cars = racingGame.createCars(names);
        //then
        for (int i = 0; i < names.length; i++) {
            Assertions.assertThat(cars.get(i).getName()).isEqualTo(names[i]);
        }

    }

}