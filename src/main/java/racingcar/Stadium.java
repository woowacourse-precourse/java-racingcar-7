package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Stadium {
    private final CarRegistry carRegistry;
    private final RaceResult raceResult;

    public Stadium(CarRegistry carRegistry, RaceResult result) {
        this.carRegistry = carRegistry;
        this.raceResult = result;
    }

    public void runGame(Integer rounds) {
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
        this.raceResult.add(carRegistry.toString()).add("\n");
    }

    private boolean doesCarMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
