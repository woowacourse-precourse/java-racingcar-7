package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Stadium {
    private final CarRegistry carRegistry;
    private final Integer rounds;

    public Stadium(CarRegistry carRegistry, Integer rounds) {
        this.carRegistry = carRegistry;
        this.rounds = rounds;
    }

    public void runGame() {
        for (int i = 0; i < rounds; i++) {
            executeOneRound();
        }
    }

    private void executeOneRound() {
        for(Car car : carRegistry.getCars()){
            if(doesCarMove()){
                car.goForward();
            }
        }
    }

    private boolean doesCarMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
