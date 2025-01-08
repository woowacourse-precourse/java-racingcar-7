package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    private final Cars cars;
    private final int attemptCount;
    private final int RANDOM_START = 0;
    private final int RANDOM_END = 9;

    public Racing(List<Car> cars, int attemptCount) {
        this.cars = new Cars(cars);
        this.attemptCount = attemptCount;
    }

    public void printAllRacingResult() {
        System.out.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            cars.playRacing(makeRandomValue());
            cars.printRacingResult();
            System.out.println();
        }
    }

    public int makeRandomValue() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

}
