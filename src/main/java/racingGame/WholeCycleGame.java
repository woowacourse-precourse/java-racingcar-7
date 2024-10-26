package racingGame;

import java.util.List;

public class WholeCycleGame {
    OneCycleGame oneCycleGame = new OneCycleGame();

    public void gameStart(List<String> participateCarList, int numberOfgameCycle) {
        for (int i = 0; i < numberOfgameCycle; i++) {
            oneCycleGame.oneGameStart(participateCarList);
        }
    }
}
