package racingGame;

import java.util.List;
import racingcar.MoveCar;

public class OneCycleGame {
    MoveCar moveCar = new MoveCar();

    public List<String> oneGameResult(List<String> participateCarList) {
        return moveCar.whichCarCanForward(participateCarList);
    }

}
