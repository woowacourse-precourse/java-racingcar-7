package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RaceService {
    private static final int MOVE_THRESHOLD = 4;

    // 라운드를 시작하고 각 자동차가 이동할지 결정
    public void playRound(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.moveForward();
            }
        }
    }

    // 이동 여부를 결정하는 메서드
    private boolean shouldMove() {
        // 0에서 9까지의 랜덤 숫자
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        // 임계값(4) 이상이면 전진 가능
        return randomNumber >= MOVE_THRESHOLD;
    }
}
