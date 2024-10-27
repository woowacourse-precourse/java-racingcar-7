package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.io.RacingCarIOHandler;

import java.util.List;

public class RacingCarGame {

    private final RacingCarIOHandler racingCarIOHandler = new RacingCarIOHandler();
    private final RaceManager raceManager = new RaceManager();

    public void run() {

        RaceCars raceCars = racingCarIOHandler.askRaceCarsNames();
        int raceCount = racingCarIOHandler.askRaceCount();

        raceCars.initializeRaceRecords(raceCount);

        for (int i = 0; i < raceCount; i++) {
            race(raceCars, i);
        }

        racingCarIOHandler.showExecutionResult(raceCount, raceCars);

        List<String> finalWinners = raceManager.calculateWinners(raceCars, raceCount);
        racingCarIOHandler.showFinalWinner(finalWinners);
    }

    private void race(RaceCars raceCars, int round) {
        for (int i = 0; i < raceCars.size(); i++) {
            Car car = raceCars.getCarByIndex(i);
            savePrevRecordToCurrentRound(car, round);
            moveForward(car, round);
        }
    }

    private void savePrevRecordToCurrentRound(Car car, int round) {
        if (round > 0) {
            car.recordPrevRaceByRound(round);
        }
    }

    private void moveForward(Car car, int round) {
        if (canMoveForward()) {
            car.moveForward(round);
        }
    }

    private boolean canMoveForward() {
        int moveForwardThreshold = getMoveForwardThreshold();
        return moveForwardThreshold >= 4;
    }

    private int getMoveForwardThreshold() {
        return Randoms.pickNumberInRange(0, 9);
    }

}