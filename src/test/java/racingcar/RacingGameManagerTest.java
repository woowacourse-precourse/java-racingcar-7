package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameManagerTest {

    @Test
    @DisplayName("show")
    void show() {
        //given
        RacingGameManager racingGame = new RacingGameManager();
        List<String> inputCars = new ArrayList<>();
        inputCars.add("yumi");
        inputCars.add("coco");
        inputCars.add("zozo");
        //when
        racingGame.ready(inputCars);
        //then
        racingGame.start(10);
    }
}