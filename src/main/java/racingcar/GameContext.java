package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;

public class GameContext {
    private final List<Car> cars;
    private final int numTries;
    private final Supplier<Integer> moveDecisionSupplier;

    public GameContext(List<Car> cars, int numTries) {
        this.cars = cars;
        this.numTries = numTries;
        this.moveDecisionSupplier = () -> Randoms.pickNumberInRange(0, 9);
    }

    public GameContext(List<Car> cars, int numTries, Supplier<Integer> moveDecisionSupplier) {
        this.cars = cars;
        this.numTries = numTries;
        this.moveDecisionSupplier = moveDecisionSupplier;
    }

    boolean shouldMove() {
        int randNum = moveDecisionSupplier.get();
        return randNum >= 4;
    }
}
