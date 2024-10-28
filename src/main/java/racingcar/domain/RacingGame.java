package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class RacingGame {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    public static void play(List<Car> cars, BigInteger round) {
        for (BigInteger i = new BigInteger("0"); i.compareTo(round) < 0; i = i.add(BigInteger.ONE)) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(RANDOM_START, RANDOM_END));
                OutputView.printRaceStatus(car);
            }
        }
    }
}
