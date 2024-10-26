package racingcar.ready;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.controller.RacingController;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

class RacingGameCreateCarTest {
    public RacingGame racingGame;
    public RacingController racingController;

    @BeforeEach
    public void init() {
        racingGame = new RacingGame();
        racingController = new RacingController(new RacingGameView(),new RacingGame());
    }

    @Test
    public void 차생성테스트() throws Exception {
        //given
        String[] names = racingGame.createNames("pobi,woni,jun");
        //when
        ArrayList<Car> cars = racingGame.createCars(names);
        //then
        for (int i = 0; i < names.length; i++) {
            Assertions.assertThat(cars.get(i).getName()).isEqualTo(names[i]);
        }

    }

}