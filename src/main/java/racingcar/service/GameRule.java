package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.RacingCar;
import racingcar.view.View;

public class GameRule {
    private final View view;

    public void startGame(RacingCar[] racingCar, int round) {
        for (int i = 0; i < round; i++) {
            moveCars(racingCar);
        }
    }

    public GameRule() {
        this.view = new View();
    }

    private void moveCars(RacingCar[] racingCar) { // 자동차들의 위치를 이동시키는 메서드
        view.executeMoveMessage();
        for (RacingCar car : racingCar) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.position();
            }
        }
    }

}
