package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = RacingView.getCarNames();
        int tryCount = RacingView.getTryCount();

        RacingController game = new RacingController(carNames, tryCount);
        game.play();
    }
}
