package racingGame;

import java.util.List;
import racingcar.MoveCar;

public class OneCycleGame {
    MoveCar moveCar = new MoveCar();

    public void oneGameStart(List<String> participateCarList) {
        List<String> carCanFowardList = moveCar.whichCarCanForward(participateCarList);
    }
}
