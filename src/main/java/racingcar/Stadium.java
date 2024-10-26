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
            car.moveIfPossible();
        }
        this.raceResult.add(carRegistry.toString()).add("\n");
    }

}
