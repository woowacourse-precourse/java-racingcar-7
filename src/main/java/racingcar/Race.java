package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<RacingCar> racingCarList;
    private int maxRoundValue;

    public Race(List<RacingCar> racingCarList, int maxRoundValue) {
        this.racingCarList = racingCarList;
        this.maxRoundValue = maxRoundValue;
    }

    void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < maxRoundValue; i++) {
            executeRound();
        }
    }

    private void executeRound() {
        for (RacingCar car : racingCarList) {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            car.move(pickedNumber);
            car.displayRoundResult();
        }
        System.out.println();
    }

    List<String> findWinner() {
        int maxForwardCount = findMaxForwardCount();
        List<String> winnerList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.isWinner(maxForwardCount)) {
                String winnerCarName = racingCar.getName();
                winnerList.add(winnerCarName);
            }
        }
        return winnerList;
    }

    private int findMaxForwardCount() {
        int maxForwardCount = 0;
        for (RacingCar racingcar : racingCarList) {
            int forwardCount = racingcar.getForwardCount();
            maxForwardCount = Math.max(maxForwardCount, forwardCount);
        }
        return maxForwardCount;
    }
}
