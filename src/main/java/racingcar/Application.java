package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.InputReader;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        final List<String> carNames = reader.readCarNames();
        final int tryCount = reader.readTryCount();

        Cars cars = new Cars(carNames);
        for (int i = 0; i < tryCount; i++) {
            cars.goOrStop(() -> Randoms.pickNumberInRange(0, 9));
        }
    }
}
