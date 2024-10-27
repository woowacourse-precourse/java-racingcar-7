package racingcar.domain;

import racingcar.car.RacingCar;

import java.util.List;

public class RaceStarter {

    public static void startRace(List<RacingCar> racingCarList, int tryMoveCount) {
        for(int i=0; i<tryMoveCount; i++) {
            for(RacingCar racingCar : racingCarList) {
                racingCar.move();
                racingCar.showRacingStatus();
            }
            System.out.println();
        }
    }
}
