package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private final int number;
    public RacingGame(List<Car> carList, int num) {
        this.carList = carList;
        this.number = num;
    }

    public void start() {
        for(int i = 0; i < number; i++) {
            // 현재 턴 진행
            playTurn();
            // 현재 턴의 상황 출력

        }
        // 결과 출력
    }

    public void playTurn() {
        carList.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }
}
