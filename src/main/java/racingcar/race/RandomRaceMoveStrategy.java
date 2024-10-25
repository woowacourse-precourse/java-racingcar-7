package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomRaceMoveStrategy implements RaceMoveStrategy {
    private int startRange = 0;
    private int endRange = 9;
    private int winningThreshold = 4;

    public RandomRaceMoveStrategy() {}

    public RandomRaceMoveStrategy(int startRange, int endRange, int winningThreshold) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.winningThreshold = winningThreshold;
    }

    @Override
    public boolean go() {
        int generatedNumber = Randoms.pickNumberInRange(startRange, endRange);
        return generatedNumber >= winningThreshold;
    }
}
