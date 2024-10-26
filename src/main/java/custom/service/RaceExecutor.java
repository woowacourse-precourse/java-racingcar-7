package custom.service;

import camp.nextstep.edu.missionutils.Randoms;
import custom.model.RacingScoreBoard;

public class RaceExecutor {
    private final RacingScoreBoard racingScoreBoard;

    public RaceExecutor(RacingScoreBoard racingScoreBoard) {
        this.racingScoreBoard = racingScoreBoard; // 주입된 racingScoreBoard 사용
    }

    private boolean isCarAllowedToMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4; // 랜덤 값이 4 이상일 경우 true 반환 (전진)
    }

    public void run() {
        for (String carName : racingScoreBoard.getRegisteredCarNames()) {
            if (isCarAllowedToMove()) {
                racingScoreBoard.addScore(carName);
            }
        }
    }
}