package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class RoundView {

    public void startRaceRound() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showRoundResults(List<RacingCar> racingCars) {
        racingCars.forEach(
                racingCar -> System.out.println(racingCar.getName() + " : " + "-".repeat((int) racingCar.getMoveCount()))
        );
        System.out.println();
    }
}
