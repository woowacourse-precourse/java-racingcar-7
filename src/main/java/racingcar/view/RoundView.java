package racingcar.view;

import racingcar.domain.RacingCars;


public class RoundView {

    public void startRaceRound() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showRoundResults(RacingCars racingCars) {
        racingCars.getRacingCars().forEach(
                racingCar -> System.out.println(racingCar.getName() + " : " + "-".repeat((int) racingCar.getMoveCount()))
        );
        System.out.println();
    }
}
