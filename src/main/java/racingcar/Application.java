package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.InputReader;
import racingcar.view.ResultWriter;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        ResultWriter writer = new ResultWriter();

        final List<String> carNames = reader.readCarNames();
        final int tryCount = reader.readTryCount();

        Cars cars = new Cars(carNames);
        writer.writeResultStart();
        for (int i = 0; i < tryCount; i++) {
            cars.goOrStop(() -> Randoms.pickNumberInRange(0, 9));
            writer.writeResult(cars);
        }

        final List<String> winnerNames = cars.findWinners()
                .stream()
                .map(Car::getName)
                .map(CarName::getContent)
                .toList();

        writer.writeWinners(winnerNames);
    }
}
